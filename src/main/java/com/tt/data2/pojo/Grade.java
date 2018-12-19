package com.tt.data2.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 *@作者:wuxuuehua
 *@时间:2018/11/21 9:44
 *@描述:Grade年级类  （对应）   grade年级表
 */

@Entity
@Table(name = "grades")
public class Grade implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gradeID;
    private  String gradeName;

    public Integer getGradeID() {
        return gradeID;
    }

    public void setGradeID(Integer gradeID) {
        this.gradeID = gradeID;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public Grade() {
    }

    public Grade(Integer gradeID, String gradeName) {
        this.gradeID = gradeID;
        this.gradeName = gradeName;
    }
}
