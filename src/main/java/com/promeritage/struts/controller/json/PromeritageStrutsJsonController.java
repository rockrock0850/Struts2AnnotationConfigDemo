package com.promeritage.struts.controller.json;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.common.net.MediaType;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.promeritage.struts.common.Constant;
import com.promeritage.struts.common.Constant.Status;
import com.promeritage.struts.common.ShareTool;
import com.promeritage.struts.module.model.Employee;
import com.promeritage.struts.module.service.IEmployeeService;
import com.promeritage.struts.module.vo.ResponseVO;
import com.promeritage.struts.module.vo.form.EmployeeVO;

@Controller
@Validations
@ParentPackage("json")
@Namespace(value = "/Struts2DemoJson")
@InterceptorRefs({ @InterceptorRef(value = "json", params = { "enableSMD", "true", "noCache", "true", "contentType",
		"application/json;charset=utf-8" }), @InterceptorRef(value = "customStack") })
@Results({ @Result(name = "json", type = "json", params = { "root", "action" }) })
public class PromeritageStrutsJsonController implements com.opensymphony.xwork2.Action {

	private final Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private IEmployeeService iEmployeeService;

	private String id;
	private String firstName;
	private String lastName;
	private String cellPhone;
	private String birthDate;
	private ResponseVO responseVO;

	public PromeritageStrutsJsonController() {
		responseVO = new ResponseVO();
	}

	@Override
	public String execute() {
		return SUCCESS;
	}

	@Action(value = "employeeNew")
	public String employeeNew() {
		try {
			Employee employee = new Employee();
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setCellPhone(null);
			employee.setBirthDate(ShareTool.toDate(birthDate, Constant.DATE_PATTERN1));
			employee = iEmployeeService.insert(employee);

			responseVO.setStatus(Status.SUCCESS.getCode());
			responseVO.setMessage(Status.SUCCESS.getMessage());
			responseVO.setResult(employee);
		} catch (Exception e) {
			log.debug(e, e);
		}

		return MediaType.JSON_UTF_8.subtype();
	}

	@Action(value = "employeeDetail")
	public String employeeDetail() {
		try {
			Employee employee = iEmployeeService.select(Long.valueOf(id));
			EmployeeVO employeeVO = new EmployeeVO();
			employeeVO.setFirstName(employee.getFirstName());
			employeeVO.setLastName(employee.getLastName());
			employeeVO.setCellPhone(employee.getCellPhone());
			employeeVO.setBirthDate(ShareTool.toStirng(employee.getBirthDate(), Constant.DATE_PATTERN1));

			responseVO.setResult(employeeVO);
		} catch (Exception e) {
			log.error(e, e);
		}

		return MediaType.JSON_UTF_8.subtype();
	}

	@Action(value = "employeeUpdate")
	public String employeeUpdate() {
		try {
			Employee employee = new Employee();
			employee.setId(Long.valueOf(id));
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setCellPhone(cellPhone);
			employee.setBirthDate(ShareTool.toDate(birthDate, Constant.DATE_PATTERN1));
			employee = iEmployeeService.update(employee);

			responseVO.setStatus(Status.SUCCESS.getCode());
			responseVO.setMessage(Status.SUCCESS.getMessage());
			responseVO.setResult(employee);
		} catch (Exception e) {
			log.error(e, e);
		}

		return MediaType.JSON_UTF_8.subtype();
	}

	@Action(value = "employeeDelete")
	public String employeeDelete() {
		ResponseVO responseVO = new ResponseVO();
		try {
			iEmployeeService.delete(Long.valueOf(id));
			responseVO.setStatus(Status.SUCCESS.getCode());
			responseVO.setMessage(Status.SUCCESS.getMessage());
			responseVO.setResult(id);
		} catch (Exception e) {
			log.error(e, e);
		}

		return MediaType.JSON_UTF_8.subtype();
	}

	/*
	 * getter/setter
	 */

	public String getFirstName() {
		return firstName;
	}

	@RequiredStringValidator(type = ValidatorType.FIELD, message = "Name Should not be blank")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public ResponseVO getResponseVO() {
		return responseVO;
	}

	public void setResponseVO(ResponseVO responseVO) {
		this.responseVO = responseVO;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}