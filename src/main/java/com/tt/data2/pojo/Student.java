package com.tt.data2.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 *@作者:wuxuuehua
 *@时间:2018/11/21 9:45
 *@描述:Student学生类   （对应）  student学生表
 */
@Entity
@Table(name="students")
public class Student implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentNo;
    private String loginPwd;
    private String studentName;

    public Integer getStudentNo() {
        return studentNo;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentNo(Integer studentNo) {
        this.studentNo = studentNo;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Student(Integer studentNo, String loginPwd, String studentName) {
        this.studentNo = studentNo;
        this.loginPwd = loginPwd;
        this.studentName = studentName;
    }

    public Student() {
    }
}
