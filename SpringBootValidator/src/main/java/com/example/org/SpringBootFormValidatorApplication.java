package com.example.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.example.org.validators.FormDetailsBasicValidator;

@SpringBootApplication
@ComponentScan({"com.example.org","com.example.org.bindings","com.example.org.mvc.controller",
		"com.example.org.service.controller","com.example.org.validators"})
public class SpringBootFormValidatorApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootFormValidatorApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFormValidatorApplication.class, args);
	}
	
	@Bean
	public InternalResourceViewResolver resolver() {
	    InternalResourceViewResolver vr = new InternalResourceViewResolver();
	    vr.setPrefix("/WEB-INF");
	    vr.setSuffix(".jsp");
	    vr.setViewClass(JstlView.class);
	    return vr;
	}
	
	/*@Bean
	FormDetailsBasicValidator formBeanValidator(){
		return new FormDetailsBasicValidator();
	}*/
}
