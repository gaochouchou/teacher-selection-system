package com.example.teacherselectionsystem.repository;

import com.example.teacherselectionsystem.entity.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
public class TeacherRepositoryTest {
    @Autowired
    TeacherRepository teacherRepository;

    @Test
    public void test_addTeacher(){
        Teacher teacher = new Teacher();
        teacher.setName("BO");
        teacher.setUsername("10000012322");
        teacher.setPassword("123456");
        teacherRepository.save(teacher);
    }

    @Transactional
    @Rollback(value = false)
    @Test
    public void test_updateActualNum(){
        teacherRepository.update(1);
    }

    @Transactional
    @Rollback(value = false)
    @Test
    public void test_updateTeacher(){
        Teacher teacher = teacherRepository.find("10000012322");
        log.debug("{}", teacher.getId());
        teacher.setQualifiedNum(20);
    }
}
