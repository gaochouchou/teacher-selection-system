package com.example.teacherselectionsystem.intercepter;

import com.example.teacherselectionsystem.component.EncryptComponent;
import com.example.teacherselectionsystem.component.MyToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
public class LoginIntercepter implements HandlerInterceptor {
    @Autowired
    EncryptComponent encryptComponent;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Optional.ofNullable(request.getHeader(MyToken.AUTHORIZATION))
                .map(auth -> encryptComponent.decryptToken(auth))
                .ifPresentOrElse(token -> {
                    request.setAttribute(MyToken.UID, token.getUid());
                    request.setAttribute(MyToken.ROLE, token.getRole());
                }, () -> {
                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "未登录");
                });

        return true;
    }
}
