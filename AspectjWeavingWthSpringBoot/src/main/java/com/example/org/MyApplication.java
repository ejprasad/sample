package com.example.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.cache.SpringCacheBasedUserCache;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@SpringBootApplication

//@EnableAspectJAutoProxy
//@EnableLoadTimeWeaving(aspectjWeaving=AspectJWeaving.ENABLED)
public class MyApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MyApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}
	
	@Bean
	public InternalResourceViewResolver resolver() {
	    InternalResourceViewResolver vr = new InternalResourceViewResolver();
	    vr.setPrefix("/WEB-INF");
	    vr.setSuffix(".jsp");
	    vr.setViewClass(JstlView.class);
	    return vr;
	}
	
	@Bean
	DigestAuthenticationEntryPoint digestEntryPoint() {
	  DigestAuthenticationEntryPoint digestEntryPoint = new DigestAuthenticationEntryPoint();
	  digestEntryPoint.setRealmName("com.example.org");
	  digestEntryPoint.setKey("XXX");
	  digestEntryPoint.setNonceValiditySeconds(120);
	  
	  //response.setHeader("WWW-Authenticate", "none");
	  
	  return digestEntryPoint;
	}
	
	@Bean
	UserCache digestUserCache() throws Exception {
	  return new SpringCacheBasedUserCache(new ConcurrentMapCache("digestUserCache"));
	}
	
	@Bean
	InstrumentationLoadTimeWeaver loadTimeWeaver(){
		return new InstrumentationLoadTimeWeaver();
	}

	/*@Bean
	MyAspect myAspect(){
		return new MyAspect();
	}*/
	
	@Bean
	@Lazy
	DigestAuthenticationFilter digestFilter(DigestAuthenticationEntryPoint digestEntryPoint, UserCache digestUserCache, UserDetailsService userDetailsService) {
	  DigestAuthenticationFilter digestFilter = new DigestAuthenticationFilter();
	  try
	  {
		  digestFilter.setAuthenticationEntryPoint(digestEntryPoint);
		  digestFilter.setUserDetailsService(userDetailsService);
		  digestFilter.setUserCache(digestUserCache);
		  return digestFilter;
	  }
	  catch (Exception e) {
	}
	  return null;
	  
	}

}