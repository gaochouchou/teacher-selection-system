package com.example.teacherselectionsystem.repository;

import com.example.teacherselectionsystem.entity.Student;
import com.example.teacherselectionsystem.repository.baseRepository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends BaseRepository<Student,Integer> {

    /**
     * 基于指定学号查找学生
     * @param studentId：学生学号
     * @return：返回查找的学生，学号唯一
     */
    @Query("select s from Student s where s.studentId=:studentId")
    Student find(@Param("studentId") int studentId);
}
