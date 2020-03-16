package com.example.teacherselectionsystem.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String name;
    private int minScore;
    private int weight;
    @OneToMany(mappedBy = "course")
    private List<CourseSelection> courseSelections;
}
