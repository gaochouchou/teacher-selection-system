package com.example.teacherselectionsystem.controller;

import com.example.teacherselectionsystem.component.EncryptComponent;
import com.example.teacherselectionsystem.component.MyToken;
import com.example.teacherselectionsystem.entity.Teacher;
import com.example.teacherselectionsystem.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/api/")
@Slf4j
public class LoginController {
    @Value("${my.teacher}")
    private String roleTeacher;
    @Value("${my.student}")
    private String roleStudent;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private EncryptComponent encrypt;

    @PostMapping("teacherLogin")
    public Map login(@RequestBody Teacher login, HttpServletResponse response) {
        log.debug("{}", login.getPassword());
        Teacher teacher = new Teacher();
        teacher = teacherService.getTeacher(login.getUsername());
        if(teacher == null){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "用户名密码错误");
        }
        log.debug("控制层收到{}", teacher);
        log.debug("password比较{}",encoder.matches(login.getPassword(),teacher.getPassword()));
        if(encoder.matches(login.getPassword(),teacher.getPassword())){
            log.debug("密码比对成功");
            MyToken token = new MyToken(teacher.getId(),MyToken.TEACHER);
            String auth = encrypt.encryptToken(token);
            response.setHeader(MyToken.AUTHORIZATION, auth);
            return Map.of("role", roleTeacher);
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "用户名密码错误");
    }
}
