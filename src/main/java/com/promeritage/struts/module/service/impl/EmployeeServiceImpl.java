package com.promeritage.struts.module.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promeritage.struts.module.dao.IEmployeeDao;
import com.promeritage.struts.module.model.Employee;
import com.promeritage.struts.module.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
    private IEmployeeDao employeeDao;

	@Override
	@Transactional("transactionManager")
	public List<Employee> select() {
		try {
			List<Employee> list = employeeDao.findAll();

			return list.size() > 0 ? list : null; 
		} catch (Exception e) {
			log.error(e, e);
		}
		
		return null;
	}

	@Override
	@Transactional("transactionManager")
	public Employee select(long id) {
		try {
			Employee employee = employeeDao.findOne(id);
			
			return employee == null ? null : employee;	
		} catch (Exception e) {
			log.error(e, e);
		}
		
		return null;
	}

	@Override
	@Transactional("transactionManager")
	public Employee insert(Employee employee) {
		try {
			employee = employeeDao.save(employee);
			
			return employee == null ? null : employee;
		} catch (Exception e) {
			log.error(e, e);
		}
		
		return null;
	}

	@Override
	@Transactional("transactionManager")
	public Employee update(Employee employee) {
		try {
			employee = employeeDao.save(employee);
			
			return employee == null ? null : employee;	
		} catch (Exception e) {
			log.error(e, e);
		}
		
		return null;
	}

	@Override
	@Transactional("transactionManager")
	public void delete(long id) {
		employeeDao.delete(id);
	}
	
}
