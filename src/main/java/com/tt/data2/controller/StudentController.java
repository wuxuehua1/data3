package com.tt.data2.controller;

import com.tt.data2.pojo.Grade;
import com.tt.data2.pojo.Student;
import com.tt.data2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

/**
 *@作者:wuxuuehua
 *@时间:2018/11/21 9:32
 *@描述:学生的控制器，负责学生的增删改查
 */
@Controller
public class StudentController {
    @Autowired
    @Qualifier("studentService")
    private StudentService studentService;

    @RequestMapping("/addGrade")
    public String addGrade() {
        Grade grade = new Grade();
        grade.setGradeName("第四学期");
        studentService.addrade(grade);
        return "ok";
    }

    @RequestMapping("/deleteGrade")
    public String deleteGrade(@RequestParam Integer gradeId) {
        studentService.deleteGrade(gradeId);
        return "ok";
    }

    @RequestMapping("/findGrade")
    @ResponseBody
    public Object findGrade() {
        List<Grade> list = studentService.findGrade();
        return list;
    }

    @RequestMapping("/getCount")
    @ResponseBody
    public Object getCount() {
        int Count = studentService.getCount();
        return Count;
    }

    @RequestMapping("/findGradeById")
    @ResponseBody
    public Object findGradeById(@RequestParam Integer gradeId) {
        Optional<Grade> grade = studentService.findGradeById(gradeId);
        return grade;
    }

    @RequestMapping("/findGradeSort")
    @ResponseBody
    public Object findGradeSort() {
        //指定排序的条件和排序的描述，即根据什么排序，打算怎么排序（升序、降序）？
        Sort sort = new Sort(Sort.Direction.DESC, "gradeID");
        List<Grade> list = studentService.findGradeSort(sort);
        return list;
    }

    @RequestMapping("/findGradePage")
    @ResponseBody
    public Object findGradePage(@RequestParam Integer pageIndex) {
        Pageable pageable = PageRequest.of(pageIndex - 1, 2);
        Page<Grade> page = studentService.findGradePage(pageable);
        System.out.println("查询总页数：" + page.getTotalPages());
        System.out.println("查询总条数：" + page.getTotalElements());
        System.out.println("当前是第几页：" + (page.getNumber() + 1));
        List<Grade> list = page.getContent();
        return list;
    }

    //1.根据名称查询学生信息getStuByName，参数是studentName
    @RequestMapping(value = "/getStuByName")
    @ResponseBody
    public Object getStuByName(@RequestParam String studentName) {
        List<Student> list = studentService.getStuByName(studentName);
        return list;
    }

    //2.根据密码查询学生信息
    @RequestMapping(value = "/getStuByPwd")
    @ResponseBody
    public Object getStuByPwd(@RequestParam String loginPwd) {
        List<Student> list = studentService.getStuByPwd(loginPwd);
        return list;
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    //3.根据学号和密码查询学生信息
    @RequestMapping(value = "/getStuByNoPwd")
    public String getStuByNoPwd(@RequestParam Integer studentNo, @RequestParam String loginPwd) {
        Student student = studentService.getStuByNoPwd(studentNo, loginPwd);
        if (student != null) {
            return "result";
        }
        return "login";
    }

    //4.根据名称模糊查询查询学生信息
    @RequestMapping(value = "/getStuByNameLike")
    @ResponseBody
    public Object getStuByNameLike(@RequestParam String studentName) {
        List<Student> list = studentService.getStuByNameLike(studentName);
        return list;
    }

    //5.根据名称模糊查询查询学生信息，并且按照学号降序查询学生信息
    @RequestMapping(value = "/getStuByNameLikeSort")
    @ResponseBody
    public Object getStuByNameLikeSort(@RequestParam String studentName) {
        List<Student> list = studentService.getStuByNameLikeSort(studentName);
        return list;
    }

    //使用JpaRepository的@Query注解方式实现所有学生信息
    //接口：http://localhost:8080/getStuByQuery
    @RequestMapping("/getStuByQuery")
    @ResponseBody
    public Object getStuByQuery() {
        List<Student> list = studentService.getStuByQuery();
        return list;
    }

    //使用JpaRepository的@Query注解方式实现修改学生信息
    //接口：http://localhost:8080/updateStuByQuery
    @RequestMapping("/updateStuByQuery")
    @ResponseBody
    public Object updateStuByQuery() {
        Integer studentNo = 1;
        String studentName = "王二";
        String loginPwd = "123";
        studentService.updateStuByQuery(studentNo, studentName, loginPwd);
        return "ok";
    }

    //使用JpaRepository的@Query注解方式实现删除学生信息
    //接口：http://localhost:8080/deleteStuByQuery?studentNo=3
    @RequestMapping("/deleteStuByQuery")
    @ResponseBody
    public Object deleteStuByQuery(@RequestParam Integer studentNo) {
        studentService.deleteStuByQuery(studentNo);
        return "ok";
    }

    //使用JpaRepository的@Query注解方式实现根据学号和密码查询学生信息
    //接口：http://localhost:8080/getStuByQueryNoPwd?studentNo=1&loginPwd=123
    @RequestMapping("/getStuByQueryNoPwd")
    @ResponseBody
    public Object getStuByQueryNoPwd(@RequestParam Integer studentNo, @RequestParam String loginPwd) {
        List<Student> list = studentService.getStuByQueryNoPwd(studentNo, loginPwd);
        return list;
    }

}