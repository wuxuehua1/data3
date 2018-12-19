package com.tt.data2.service;

import com.tt.data2.pojo.Grade;
import com.tt.data2.pojo.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StudentService {
    void addrade(Grade grade);
    
    List<Grade> findGrade();

    int getCount();

    void deleteGrade(Integer gradeId);

    Optional<Grade> findGradeById(Integer gradeId);

    Page<Grade> findGradePage(Pageable pageable);

    List<Grade> findGradeSort(Sort sort);

    List<Student> getStuByName(String studentName);

    List<Student> getStuByPwd(String loginPwd);

    Student getStuByNoPwd(Integer studentNo, String loginPwd);

    List<Student> getStuByNameLike(String studentName);

    List<Student> getStuByNameLikeSort(String studentName);


    List<Student> getStuByQuery();


    void updateStuByQuery(Integer studentNo, String studentName, String loginPwd);

    void deleteStuByQuery(Integer studentNo);

    List<Student> getStuByQueryNoPwd(Integer studentNo, String loginPwd);
}
