package com.example.teacherselectionsystem.component;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@Component
public class RequestComponent {
    public int getUid() {
        return (int) RequestContextHolder.currentRequestAttributes()
                .getAttribute(MyToken.UID, RequestAttributes.SCOPE_REQUEST);
    }

    public String getRole() {
        return (String) RequestContextHolder.currentRequestAttributes()
                .getAttribute(MyToken.ROLE, RequestAttributes.SCOPE_REQUEST);
    }
}
