package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.entity.Employee;
import com.example.model.entity.Phone;
import com.example.model.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EntityManager em;
	
	@RequestMapping("/")  
    public ModelAndView employeeWorld() {
		
		Session s = em.unwrap(Session.class);
		Transaction tx = s.beginTransaction();
		
		Employee e1 = new Employee("Ronaldo","keeper");
		
		Phone p1 = new Phone();
		p1.setContact("8080808080");
		Phone p2 = new Phone();
		p2.setContact("8080808081");
		List<Phone> fones = new ArrayList<>();
		fones.add(p1);
		fones.add(p2);
		
		e1.setPhones(fones);		
		s.save(e1);
		tx.commit();
		
		List<Employee> es = employeeService.getEmployeeList();
        for (Employee e : es) {
			System.out.println(e.getPhones().get(0));
		}
        
        ModelAndView model = new ModelAndView("index");
		model.addObject("lists", es);
		s.close();
		return model;
		
	}
	

}
