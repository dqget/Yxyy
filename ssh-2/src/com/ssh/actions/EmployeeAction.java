package com.ssh.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.ssh.entities.Employee;
import com.ssh.service.DepartmentService;
import com.ssh.service.EmployeeService;

public class EmployeeAction extends ActionSupport implements RequestAware,ModelDriven<Employee>,Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private EmployeeService employeeService;
	private DepartmentService departmentService;
	private InputStream inputStream;
	private Employee model;
	private String lastName;
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setemployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public String delete(){
		
		try {
			employeeService.delete(id);
			inputStream=new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				inputStream=new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return "ajax-success";
	}
	public String list() {
		request.put("employees", employeeService.getAll());
		//System.out.println("----------"+employeeService.getAll().size());
		return "list";
	}

	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;

	}
	public String input() {
		
		request.put("departments",departmentService.getAll());
		//System.out.println(departmentService.getAll().size());
		return INPUT;
	}
	@Override
	public void prepare() throws Exception {}
	public void prepareSave(){
		model=new Employee();
	}
	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	public String save(){
		model.setCreateTime(new Date());
		employeeService.saveOrUpdate(model);
		return SUCCESS;
	}
	public String validateLastName() throws UnsupportedEncodingException{
		if(employeeService.listNameIsValid(lastName)){
			inputStream =new ByteArrayInputStream("1".getBytes("UTF-8"));
		}else {
			inputStream =new ByteArrayInputStream("0".getBytes("UTF-8"));
		}
		return "ajax-success";
	}
}
