package com.example.org.service.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.org.bindings.FormDetailsBasicBackingBean;
import com.example.org.validators.FormDetailsBasicValidator;


@RestController
public class MyServiceController {
	
	/*@Autowired
	FormDetailsBasicValidator formValidator;*/
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new FormDetailsBasicValidator());
    }

    @RequestMapping(path = "/getServiceId", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public ResponseEntity<FormDetailsBasicBackingBean> add(@Valid @RequestBody FormDetailsBasicBackingBean reqBody) {
    	
    	reqBody.printString();
       	return ResponseEntity.ok().body(reqBody);

    }

}