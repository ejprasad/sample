package com.example.org.service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyServiceController {
	

    @RequestMapping(path = "/getServiceId", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public ResponseEntity<Object> add(@RequestBody Object reqBody) {
    	
       	return ResponseEntity.ok().body(reqBody);

    }

}