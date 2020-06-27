package com.example.teacherselectionsystem.service;

import com.example.teacherselectionsystem.entity.CourseSelection;
import com.example.teacherselectionsystem.entity.Student;
import com.example.teacherselectionsystem.entity.Teacher;
import com.example.teacherselectionsystem.repository.CourseRepository;
import com.example.teacherselectionsystem.repository.CourseSelecionRepository;
import com.example.teacherselectionsystem.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional
@Service
public class StudentService {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CourseSelecionRepository courseSelecionRepository;
    @Autowired
    StudentRepository studentRepository;

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public Student getStudent(int studentID){
        return studentRepository.find(studentID);
    }

    public Student getStudentById(Integer id){
        return studentRepository.findbyid(id);
    }

    public List<CourseSelection> getStudentSelection(Integer id){
        return studentRepository.listCourses(id);
    }

//    保存/新增数据
    public CourseSelection addCourseselection(CourseSelection courseSelection){
        return courseSelecionRepository.save(courseSelection);
    }

    public boolean ScoreComparison(){

        return true;
    }

}
