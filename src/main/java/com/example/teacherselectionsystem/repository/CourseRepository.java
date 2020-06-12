package com.example.teacherselectionsystem.repository;

import com.example.teacherselectionsystem.entity.Course;
import com.example.teacherselectionsystem.repository.baseRepository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends BaseRepository<Course,Integer> {
    @Query("select c from Course c")
    List<Course> list();
}
