package com.example.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.model.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> listEmployees(); 

}
