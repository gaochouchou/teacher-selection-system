package com.example.teacherselectionsystem.repository;

import com.example.teacherselectionsystem.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

@SpringBootTest
@Slf4j
public class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;

    @Test
    public void test_addStudent(){
        Student student = new Student();
        student.setStudentId(2017123457);
        student.setName("Jie");
        studentRepository.save(student);
    }

    /**
     * 测试JPQL基于学号查询学生信息，注意学号为int类型
     */
    @Test
    public void test_findStudent(){
        Student student = studentRepository.find(2017123457);
        log.debug("{}", student.getName());
    }
}
