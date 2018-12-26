package com.example.org;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.example.services.Message;

@WebService
public class HelloServiceImpl implements HelloService{
	
	String str = "Welcome Homie !!! ";
	Message m;

	@Override
	@WebMethod 
	public void setMessage(String msg) {
		
		m = new Message();
		m.setMsg(str);
		m.setName(msg);
	System.out.println("Message set to: " + m.getName());
	
	}

	@Override
	@WebMethod
	public Message getMessage() {
		m = new Message();
		m.setName("Guest!!!");
		m.setMsg("Hello...");
		return m;
	}

}
