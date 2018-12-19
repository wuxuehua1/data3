package com.tt.data2.service.impl;

import com.tt.data2.dao.StudentDao;
import com.tt.data2.dao.StudentDao2;
import com.tt.data2.pojo.Grade;
import com.tt.data2.pojo.Student;
import com.tt.data2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("studentService")
public class StudentServiceImpl implements StudentService{
    @Autowired
    @Qualifier("studentDao")
    private StudentDao studentDao;

    @Autowired
    @Qualifier("studentDao2")
    private StudentDao2 studentDao2;

   @Transactional
    public void addrade(Grade grade) {
        studentDao.save(grade);
    }

    @Transactional
    public List<Grade> findGrade() {
        return (List<Grade>) studentDao.findAll();
    }


    public int getCount() {
        return (int) studentDao.count();
    }


    public void deleteGrade(Integer gradeId) {
        studentDao.deleteById(gradeId);
    }

    @Override
    public Optional<Grade> findGradeById(Integer gradeId) {
        return studentDao.findById(gradeId);
    }



    @Override
    public Page<Grade> findGradePage(Pageable pageable) {
       return studentDao.findAll(pageable);
    }

    @Override
    public List<Grade> findGradeSort(Sort sort) {
        return (List<Grade>) studentDao.findAll(sort);
    }

    @Override
    public List<Student> getStuByName(String studentName) {
        return studentDao2.findStudentByStudentName(studentName);
    }

    @Override
    public List<Student> getStuByPwd(String loginPwd) {
        return studentDao2.findStudentByLoginPwd(loginPwd);
    }

    @Override
    public Student getStuByNoPwd(Integer studentNo, String loginPwd) {
        return studentDao2.findStudentByStudentNoAndLoginPwd(studentNo,loginPwd);
}

    @Override
    public List<Student> getStuByNameLike(String studentName) {
        return studentDao2.findStudentByStudentNameLike("%"+studentName+"%");
    }

    @Override
    public List<Student> getStuByNameLikeSort(String studentName) {
        return studentDao2.findStudentByStudentNameLikeOrderByStudentNoDesc("%"+studentName+"%");
    }

    @Override
    public List<Student> getStuByQuery() {
        return studentDao2.getStuByQuery();
    }

    @Transactional
    public void updateStuByQuery(Integer studentNo, String studentName, String loginPwd) {
        studentDao2.updateStuByQuery(studentNo,studentName,loginPwd);
    }

    @Transactional
    public void deleteStuByQuery(Integer studentNo) {
        studentDao2.deleteStuByQuery(studentNo);
    }

    @Override
    public List<Student> getStuByQueryNoPwd(Integer studentNo, String loginPwd) {
        return studentDao2.getStuByQueryNoPwd(studentNo,loginPwd);
    }


}
