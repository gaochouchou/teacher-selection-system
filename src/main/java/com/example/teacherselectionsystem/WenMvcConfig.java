package com.example.teacherselectionsystem;

import com.example.teacherselectionsystem.entity.Teacher;
import com.example.teacherselectionsystem.intercepter.LoginIntercepter;
import com.example.teacherselectionsystem.intercepter.TeacherIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WenMvcConfig implements WebMvcConfigurer {
    @Autowired
    private LoginIntercepter loginInterceptor;
    @Autowired
    private TeacherIntercepter teacherIntercepter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/teacherLogin","/api/studentLogin", "/api/test");

        registry.addInterceptor(teacherIntercepter)
                .addPathPatterns("/api/teacher/**");
    }
}
