package com.learning.customer.customer;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	// to package the application as WAR file and deploy in external servlet container
	// the class needs to extend - SpringBootServletInitializer class.
	// we also need to execute the class which is annotated by SpringBootApplication
	// in our example it is - customerApplication.java
	// we can put main method and execute this same class even 
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CustomerApplication.class);
	}

}
