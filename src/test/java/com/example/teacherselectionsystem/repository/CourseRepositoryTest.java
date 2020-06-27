package com.example.teacherselectionsystem.repository;


import com.example.teacherselectionsystem.entity.Course;
import com.example.teacherselectionsystem.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CourseRepositoryTest {
    @Autowired
    CourseRepository courseRepository;

    @Test
    public void test_addCourse(){
        Course course = new Course();
        course.setName("web");
        course.setWeight(2);
        course.setMinScore(70);
        courseRepository.save(course);
        Course course1 = new Course();
        course1.setName("Frame");
        course1.setWeight(1);
        course1.setMinScore(70);
        courseRepository.save(course1);
        Course course2 = new Course();
        course2.setName("Java");
        course2.setWeight(3);
        course2.setMinScore(70);
        courseRepository.save(course2);
    }
}

