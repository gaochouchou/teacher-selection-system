package com.example.teacherselectionsystem.intercepter;

import com.example.teacherselectionsystem.component.MyToken;
import com.example.teacherselectionsystem.component.RequestComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TeacherIntercepter implements HandlerInterceptor {
    @Autowired
    private RequestComponent requestComponent;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (requestComponent.getRole() != MyToken.TEACHER) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "无权限");
        }
        return true;
    }
}
