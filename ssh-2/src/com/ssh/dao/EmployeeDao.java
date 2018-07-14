package com.ssh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ssh.entities.Employee;

public class EmployeeDao extends BaseDao {

	public List<Employee> getAll(){
		String hql="FROM Employee e LEFT OUTER JOIN FETCH e.department";
		return getSession().createQuery(hql).list();
	}
	public void delete(int id) {
		String hql="DELETE FROM Employee e WHERE e.id = ?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}

	public void saveOrUpdate(Employee e){
		getSession().saveOrUpdate(e);
	}
	public Employee getEmployeeByLastName(String lastName){
		String hql="FROM Employee e WHERE e.lastName = ?";
		System.out.println(lastName);
		Query query=getSession().createQuery(hql).setString(0, lastName);
		Employee employee = (Employee) query.uniqueResult();
		System.out.println(employee);
		return employee;
	}
}
