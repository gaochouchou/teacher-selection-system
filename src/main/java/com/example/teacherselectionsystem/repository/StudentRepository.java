package com.example.teacherselectionsystem.repository;

import com.example.teacherselectionsystem.entity.CourseSelection;
import com.example.teacherselectionsystem.entity.Student;
import com.example.teacherselectionsystem.entity.Teacher;
import com.example.teacherselectionsystem.repository.baseRepository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends BaseRepository<Student,Integer> {

    /**
     * 基于指定学号查找学生
     * @param studentId
     * @return
     */
    @Query("select s from Student s where s.studentId=:studentId")
    Student find(@Param("studentId") int studentId);

    /**
     * 查询所有学生
     * @return
     */
    @Query("from Student u")
    List<Student> list();

    /**
     * 查询指定id学生选课信息
     * @param studentId
     * @return
     */
    @Query("select s.courseSelections FROM Student s WHERE s.studentId=:studentId")
    List<CourseSelection> listCourses(@Param("studentId") int studentId);


    @Query("select s from Student s where s.id=:id")
    Student findbyid(@Param("id") int id);


}
