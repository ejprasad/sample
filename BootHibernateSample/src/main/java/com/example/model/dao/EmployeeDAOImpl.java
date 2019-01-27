package com.example.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.example.model.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@PersistenceContext
	private EntityManager entityManager;
	  
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> listEmployees() {
		
		Session session = entityManager.unwrap(Session.class);
		//List<Employee> empList = session.createQuery("from Employee a inner join a.phones b where b.ownerId=a.id", Employee.class).list();
		List<Employee> empList = session.createCriteria(Employee.class).addQueryHint("Phones").list();
		return empList;
	}
	
	

}
