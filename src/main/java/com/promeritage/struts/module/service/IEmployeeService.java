package com.promeritage.struts.module.service;

import java.util.List;

import com.promeritage.struts.module.model.Employee;
import com.promeritage.struts.module.vo.form.EmployeeVO;

public interface IEmployeeService {
	
	public List<Employee> select();
	
	public Employee select(long id);
	
	public Employee insert(Employee employee);

	public Employee update(Employee employee);

	public void delete(long id);

}
