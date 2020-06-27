package com.example.teacherselectionsystem.component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyToken {
    public static final String AUTHORIZATION = "authorization";
    public static final String UID = "uid";
    public static final String ROLE = "role";

    public static final String STUDENT = "bb63e5f7e0f2ffae845c";
    public static final String TEACHER = "6983f953b49c88210cb9";

    private Integer uid;
    private String role;
}
