package com.example.org.bindings;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonAutoDetect(creatorVisibility = JsonAutoDetect.Visibility.ANY, fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class FormDetailsBasicBackingBean {
	
	String htno;
	String dob;
	String passYear;
	String phone;
	
	@JsonCreator
	public FormDetailsBasicBackingBean(
			@JsonProperty("htno") String htno, 
			@JsonProperty("dob") String dob, 
			@JsonProperty("passYear") String passYear, 
			@JsonProperty("phone") String phone) 
	{
		super();
		this.htno = htno;
		this.dob = dob;
		this.passYear = passYear;
		this.phone = phone;
	}	
	
	public void printString(){
		System.out.println("htno"+htno);
		System.out.println("dob"+dob);
		System.out.println("pass year"+passYear);
		System.out.println("mobile"+phone);
	}

	public String getHtno() {
		return htno;
	}

	public void setHtno(String htno) {
		this.htno = htno;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPassYear() {
		return passYear;
	}

	public void setPassYear(String passYear) {
		this.passYear = passYear;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
