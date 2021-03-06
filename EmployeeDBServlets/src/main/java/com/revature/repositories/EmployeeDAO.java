package com.revature.repositories;

import java.util.List;

import com.revature.models.Employee;

//Data Access Object - the obj (in impl form) that we use to access our DB
//We use the DAO design pattern to seperate business logic (java) from our persistence layer
//DAO is for CRUD methods

public interface EmployeeDAO {
	
	public boolean insert(Employee e); //returns true if successfully inserted
	public boolean update(Employee e);
	
	public List<Employee> findAll();
	

}
