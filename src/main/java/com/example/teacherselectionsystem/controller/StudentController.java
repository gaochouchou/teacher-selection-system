package com.example.teacherselectionsystem.controller;


import com.example.teacherselectionsystem.component.RequestComponent;
import com.example.teacherselectionsystem.entity.Course;
import com.example.teacherselectionsystem.entity.CourseSelection;
import com.example.teacherselectionsystem.entity.Student;
import com.example.teacherselectionsystem.entity.Teacher;
import com.example.teacherselectionsystem.service.CourseService;
import com.example.teacherselectionsystem.service.StudentService;
import com.example.teacherselectionsystem.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
@Slf4j
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    RequestComponent requestComponent;
    @Autowired
    CourseService courseService;
    @Autowired
    TeacherService teacherService;

    @GetMapping("index")
    public Map getStudent(){
        log.debug("student/index");
        Student s = studentService.getStudentById(requestComponent.getUid());
        log.debug("getuid:{}", requestComponent.getUid());
        List<Course> courses = courseService.getAllCourse();
        if(s.isIfSelected()==true){
            return Map.of("IfSelected", true,"courses",courses);
        }
        else return Map.of("IfSelected", false,"courses",courses);
    }

    @PostMapping("submit")
    public Map submit(@RequestBody Map<String,List<CourseSelection>> form ){
        log.debug("student/submit");
        log.debug("form输出{}",form);
        List<CourseSelection> courseSelections = form.get("courses");

        Student s = studentService.getStudentById(requestComponent.getUid());
        log.debug("getuid:{}", requestComponent.getUid());
        List<Course> courses = courseService.getAllCourse();

//        将学生信息存入数据库
        for (int i = 0; i < courseSelections.size(); i++) {
            CourseSelection cs = courseSelections.get(i);
            for (int j = 0; j < courses.size(); j++) {
                Course c = courses.get(j);
                if(cs.getCourse().getName().equals(c.getName())){
                    CourseSelection courseSelection = new CourseSelection();
                    courseSelection.setScore(cs.getScore());
                    courseSelection.setCourse(c);
                    courseSelection.setStudent(s);
                    log.debug("{}", courseSelection);
                    studentService.addCourseselection(courseSelection);
                }
            }
        }

//        校验是否有入选资格
        for (int i = 0; i < courseSelections.size(); i++) {
            CourseSelection cs = courseSelections.get(i);
            int csscore = cs.getScore();
            for (int j = 0; j < courses.size(); j++){
                Course c = courses.get(j);
                int cscore = c.getMinScore();
//                log.debug("最低成绩{}", c.getMinScore());
                if(cs.getCourse().getName().equals(c.getName()) ){
                    if(csscore < cscore){
                        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "无入选资格，请联系其他老师");
                    }
                }
            }
//            log.debug("学生成绩{}", cs.getScore());
        }
        Teacher t = teacherService.getTeacher("2017214218");
        if(t.getActualNum() < t.getQualifiedNum()){
            s.setIfSelected(true);
            s.setTeacher(t);
            studentService.addStudent(s);
            teacherService.updateActual();
        }
        else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "名额不足，请联系其他导师");
        }
        return Map.of("succeed", true);
    }
}
