package com.tt.data2.dao;

import com.tt.data2.pojo.Grade;

import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentDao extends JpaRepository<Grade,Integer> {

}
