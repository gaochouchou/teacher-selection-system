package com.example.teacherselectionsystem.component;

import com.example.teacherselectionsystem.entity.Teacher;
import com.example.teacherselectionsystem.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
public class Password {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TeacherService teacherService;

    @Test
    public void testPassword(){
        Teacher teacher = teacherService.getTeacher("2017214218");
        log.debug("{}", teacher);
//        if(teacher!=null){
//
//        log.debug("{}", passwordEncoder.matches("2017214218", teacher.getPassword()));
//        }


    }
}
