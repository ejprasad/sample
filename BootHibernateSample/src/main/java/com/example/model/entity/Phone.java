
  package com.example.model.entity;
  
  import javax.persistence.Column; 
  import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Lazy;
  
  @Embeddable
  @Table(schema="employeeDb", name="Phone")
  public class Phone {
  
	  @Column(name="contact")
	  private String contact;
	  
	  public String getContact() { 
		  return contact; 
	  }
	  
	  public void setContact(String contact) { 
		  this.contact = contact; 
	  }
	 
	  public Phone() {
		  
	  }
  	  
  }
 