package com.promeritage.struts.controller;

import java.rmi.RemoteException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.promeritage.struts.common.Constant;
import com.promeritage.struts.module.model.Employee;
import com.promeritage.struts.module.service.IEmployeeService;

import t320.nks34.HelloServicePortType;
import t320.nks34.HelloServicePortTypeProxy;

@Controller
@ParentPackage("struts")
@InterceptorRefs({
	@InterceptorRef(value = "customStack")
})
@Namespace(value = "/demo")
public class PromeritageStrutsController implements com.opensymphony.xwork2.Action {

	private final Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private IEmployeeService iEmployeeService;

	private HelloServicePortTypeProxy helloServicePortTypeProxy;

	private List<Employee> list;

	@Override
	public String execute() {
		return SUCCESS;
	}

	@Action(value = "index", results = {
			@Result(name = SUCCESS, location = Constant.SYSTEM_INDEX)})
	public String index() throws RemoteException {
		helloServicePortTypeProxy = new HelloServicePortTypeProxy();
		HelloServicePortType msg = helloServicePortTypeProxy.getHelloServicePortType();
		list = iEmployeeService.select();

		return SUCCESS;
	}

	/*
	 * getter/setter
	 */

	public List<Employee> getList() {
		return list;
	}

	public void setList(List<Employee> list) {
		this.list = list;
	}

}
