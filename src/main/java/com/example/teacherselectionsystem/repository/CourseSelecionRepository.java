package com.example.teacherselectionsystem.repository;

import com.example.teacherselectionsystem.entity.CourseSelection;
import com.example.teacherselectionsystem.repository.baseRepository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseSelecionRepository extends BaseRepository<CourseSelection,Integer> {
}
