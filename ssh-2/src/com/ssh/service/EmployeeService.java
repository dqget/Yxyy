package com.ssh.service;

import java.util.List;

import com.ssh.dao.EmployeeDao;
import com.ssh.entities.Employee;

public class EmployeeService {
	private EmployeeDao employeeDao;
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	public List<Employee> getAll() {
		return employeeDao.getAll();
	}
	public void delete(int id) {
		employeeDao.delete(id);
	}
	public void saveOrUpdate(Employee e){
		employeeDao.saveOrUpdate(e);	
	}
	public boolean listNameIsValid(String listName){
		return employeeDao.getEmployeeByLastName(listName) == null;
	}

}
