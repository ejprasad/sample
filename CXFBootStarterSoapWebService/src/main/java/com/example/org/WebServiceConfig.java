package com.example.org;


import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServiceConfig {
    @Autowired
    private Bus bus;
 
  //for more info on EndPointImpl class -> http://www.massapi.com/class/en/EndpointImpl-4.html
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new HelloServiceImpl());
        endpoint.publish("/hello_1.0");
        //endpoint.setWsdlLocation("/target/generated/wsdl/HelloServiceImpl.wsdl");
        return endpoint;
    }    
}