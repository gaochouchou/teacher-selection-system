package com.example.teacherselectionsystem.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int studentId;
    private boolean ifSelected;
    @ManyToOne
    private Teacher teacher;
    @OneToMany(mappedBy = "student")
    private List<CourseSelection> courseSelections;
}
