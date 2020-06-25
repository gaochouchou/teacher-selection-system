package com.example.teacherselectionsystem.component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyToken {
    public static final String AUTHORIZATION = "authorization";
    public static final String UID = "uid";
    public static final String ROLE = "role";

    public static final String STUDENT = "student";
    public static final String TEACHER = "teacher";

    private Integer uid;
    private String role;
}
