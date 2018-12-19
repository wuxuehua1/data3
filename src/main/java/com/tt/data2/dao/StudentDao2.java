package com.tt.data2.dao;

import com.tt.data2.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface StudentDao2 extends JpaRepository<Student,Integer> {
    //1.根据名称查询学生信息getStuByName，参数是studentName
    List<Student> findStudentByStudentName(String studentName);

    //2.根据密码查询学生信息
    List<Student> findStudentByLoginPwd(String loginPwd);

    //3.根据学号和密码查询学生信息
    Student findStudentByStudentNoAndLoginPwd(Integer studentNo, String loginPwd);

    //4.根据名称模糊查询学生信息
    List<Student> findStudentByStudentNameLike(String studentName);

    //5.根据名称模糊查询查询学生信息，并且按照学号降序查询学生信息
    List<Student> findStudentByStudentNameLikeOrderByStudentNoDesc(String studentName);


    //6.
    @Query("select s from Student as s")
    List<Student> getStuByQuery();



    //增 删 改 都需要进行事务处理，需要加注解@Modifying

    //@Query("update Student set studentName = ?2,loginPwd = ?3 where studentNo = ?1")
    @Modifying
    @Query("update Student set studentName = :studentName,loginPwd =:loginPwd where studentNo=:studentNo ")
    void updateStuByQuery(@Param("studentNo") Integer studentNo, @Param("studentName") String studentName, @Param("loginPwd") String loginPwd);
    @Modifying
    @Query("delete from Student where studentNo =?1")
    void deleteStuByQuery(Integer studentNo);
    @Query("select s from Student s where s.studentNo=?1 and s.loginPwd=?2")
    List<Student> getStuByQueryNoPwd(Integer studentNo, String loginPwd);
}