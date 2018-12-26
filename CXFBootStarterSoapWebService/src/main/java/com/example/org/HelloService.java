package com.example.org;

import com.example.services.Message;


public interface HelloService {

	public void setMessage(String msg);
	
	public Message getMessage();
}
