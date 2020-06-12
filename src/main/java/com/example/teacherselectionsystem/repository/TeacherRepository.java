package com.example.teacherselectionsystem.repository;

import com.example.teacherselectionsystem.entity.Teacher;
import com.example.teacherselectionsystem.repository.baseRepository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends BaseRepository<Teacher,Integer> {

    /**
     * 基于教师登陆用户名查询教师信息
     * @param teahcerUSerName：教师用户名
     * @return：教师对象
     */
    @Query("from Teacher t where t.username =:teahcerUSerName")
    Teacher find(@Param("teahcerUSerName") String teahcerUSerName);

    /**
     * 基于id，更新教师已选学生人数，每次+1
     * @param id：教师id
     * @return：更新的数据行数
     */
    @Modifying
    @Query("update Teacher t set t.actualNum=t.actualNum+1 where t.id=:id")
    int update(@Param("id") int id);

    /**
     * 基于指定id查询老师
     * @param num
     * @return
     */
    @Query("from Teacher t where t.id=:num ")
    Teacher find(@Param("num") int num);

}
