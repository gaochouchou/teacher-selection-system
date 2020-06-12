package com.example.teacherselectionsystem.service;

import com.example.teacherselectionsystem.entity.Teacher;
import com.example.teacherselectionsystem.repository.CourseRepository;
import com.example.teacherselectionsystem.repository.CourseSelecionRepository;
import com.example.teacherselectionsystem.repository.StudentRepository;
import com.example.teacherselectionsystem.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@Service
public class TeacherService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CourseSelecionRepository selecionRepository;
    @Autowired
    TeacherRepository teacherRepository;

    public Teacher getTeacherById(Integer id){
        return teacherRepository.find(id);
    }

    public Teacher addTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }
}
