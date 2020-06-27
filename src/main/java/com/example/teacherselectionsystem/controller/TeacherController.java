package com.example.teacherselectionsystem.controller;

import com.example.teacherselectionsystem.component.RequestComponent;
import com.example.teacherselectionsystem.entity.Course;
import com.example.teacherselectionsystem.entity.Student;
import com.example.teacherselectionsystem.entity.Teacher;
import com.example.teacherselectionsystem.service.CourseService;
import com.example.teacherselectionsystem.service.StudentService;
import com.example.teacherselectionsystem.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/teacher")
@Slf4j
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    private RequestComponent requestComponent;
    @Autowired
    private CourseService courseService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private StudentService studentService;


    @GetMapping("index")
    public Map getTeacher(){
        log.debug("teacher/index");
        Teacher t = teacherService.getTeacherById(requestComponent.getUid());
        log.debug("getuid:{}", requestComponent.getUid());
        List<Course> courses = courseService.getAllCourse();
        return Map.of(
                "teacher", t,
                "courses",courses,
                "students", t.getStudents());
    }

    @PostMapping("setWeight")
    public Map setWeight(@RequestBody Course course){
        log.debug("进入setWeight");
        if(course.getId() == 0 || course.getWeight() == 0 || course.getMinScore() == 0
        ){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "课程信息不完整,修改失败");
        }
        Course course1=courseService.getCourseById(course.getId());
        course1.setMinScore(course.getMinScore());
        course1.setWeight(course.getWeight());
        courseService.addCourse(course1);
        return Map.of("course",course);
    }

    @PostMapping("postAmount")
    public Map postAMount(@RequestBody Teacher teacher){
        log.debug("进入postAmount");
        if(teacher.getQualifiedNum() == 0){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "禁止设置0位学生");
        }
        Teacher t = teacherService.getTeacherById(requestComponent.getUid());
        if(teacher.getQualifiedNum() <= t.getActualNum()){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "已选学生超过设置，修改失败");
        }
        t.setQualifiedNum(teacher.getQualifiedNum());
        teacherService.addTeacher(t);
        return Map.of("t",t);
    }

    @PostMapping("addStudent")
    public Map postStudent(@RequestBody Student student){
        log.debug("addStudent");
        log.debug("{}",student);

        Student s = new Student();
        s.setStudentId(student.getStudentId());
        s.setName(student.getName());
        s.setPassword(passwordEncoder.encode(String.valueOf(student.getStudentId())));
        s.setIfSelected(false);
        studentService.addStudent(s);
        return Map.of("student",student);
    }

    @PostMapping("selectStudent")
    public Map seleectStudent(@RequestBody Student student){
        log.debug("addStudent");
        log.debug("{}",student);
        Student s = studentService.getStudent(student.getStudentId());
        log.debug("{}",s);
        if(s == null || !s.getName().equals(student.getName()) ){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "未找到该学生");
        }
        Teacher t = teacherService.getTeacherById(requestComponent.getUid());
        if(t.getActualNum() < t.getQualifiedNum()){
            s.setIfSelected(true);
            s.setTeacher(t);
            studentService.addStudent(s);
            teacherService.updateActual();
        }
        else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "名额不足，请联系其他导师");
        }
        return Map.of("student",s);
    }
}
