package com.example.teacherselectionsystem.service;

import com.example.teacherselectionsystem.repository.CourseRepository;
import com.example.teacherselectionsystem.repository.CourseSelecionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@Service
public class StudentService {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CourseSelecionRepository courseSelecionRepository;

}
