package com.example.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.context.annotation.Lazy;

@Entity
@Table(schema="employeeDb", name="Employee")

public class Employee {
	
	@Id
	@SequenceGenerator(name="dbseq", sequenceName="ORACLE_SEQ", allocationSize=1, initialValue=10)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="dbseq")
    @Column(name = "id", unique = true, nullable = false)
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String role;
	
	@ElementCollection
	@CollectionTable(name="phones", schema="employeeDb")
	private List<Phone> phones = new ArrayList<>();
	
	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", role=" + role + ", phones=" + phones + "]";
	}
		
	public Employee(String name, String role) {
		this.name = name;
		this.role = role;
	}

	public Employee() {
		
	}
}
