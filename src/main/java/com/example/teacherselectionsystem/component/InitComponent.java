package com.example.teacherselectionsystem.component;

import com.example.teacherselectionsystem.entity.Teacher;
import com.example.teacherselectionsystem.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InitComponent implements InitializingBean {
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    TeacherService teacherService;

    @Override
    public void afterPropertiesSet() throws Exception {
        Teacher teacher = new Teacher();
        int num = 1;
        teacher = teacherService.getTeacher("2017214218");
        if(teacher == null){
            Teacher t = new Teacher();
            t.setId(num);
            t.setUsername("2017214218");
            t.setName("JIE");
            t.setQualifiedNum(15);
            t.setPassword(encoder.encode("2017214218"));
            teacherService.addTeacher(t);
        }
    }
}
