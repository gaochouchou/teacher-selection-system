package com.example.teacherselectionsystem.service;

import com.example.teacherselectionsystem.entity.Course;
import com.example.teacherselectionsystem.entity.Teacher;
import com.example.teacherselectionsystem.repository.CourseRepository;
import com.example.teacherselectionsystem.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional
@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    StudentRepository studentRepository;

    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }

    public Course getCourseById(int id){
        return courseRepository.findById(id).orElse(null);
    }

    public Course addCourse(Course course){
        return courseRepository.save(course);
    }
}
