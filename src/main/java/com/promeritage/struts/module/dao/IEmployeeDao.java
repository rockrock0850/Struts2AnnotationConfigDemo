package com.promeritage.struts.module.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promeritage.struts.module.model.Employee;

public interface IEmployeeDao extends JpaRepository<Employee, Long> {

}