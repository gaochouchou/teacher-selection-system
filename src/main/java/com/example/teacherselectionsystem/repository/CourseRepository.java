package com.example.teacherselectionsystem.repository;

import com.example.teacherselectionsystem.entity.Course;
import com.example.teacherselectionsystem.repository.baseRepository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends BaseRepository<Course,Integer> {
}
