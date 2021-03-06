package com.revature.services;

import java.util.List;

import com.revature.models.Employee;
import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.EmployeeDAOImpl;

public class EmployeeService {
	
	public static EmployeeDAO eDao = new EmployeeDAOImpl();
	
	public static boolean insert(Employee e) {
		return eDao.insert(e);	
	}

	public static boolean update(Employee e) {
		return eDao.update(e);
	}
	
	public static List<Employee> findAll() {
		return eDao.findAll();
	}
	
	public static Employee findByUsername(String username) {
		List<Employee> all = eDao.findAll();
		
		for(Employee e : all) {
			if(e.getUsername().equals(username)) {
				return e;
			}
		}
		return null;
	
}

//confirm login method

public static Employee confirmLogin(String username, String password) {
	
	//we are using the above method
	Employee e = findByUsername(username);
	
//	if (e == null) return null;
//	
//	return (e.getPassword().equals(password)) ?  e :  null;
	
	if (e == null) {
		return null;
	}
	
	if (e.getPassword().equals(password)) {
		return e;
	} else {
		return null;
	}
}
	
}
