package com.learning.customer.customer;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

import com.learning.customer.model.Customer;

@SpringBootApplication
@RestController

public class CustomerApplication implements CommandLineRunner{
	static ArrayList<Customer> customerList;
	
	// property appName is going to get the value of 
	//prop-spring.application.name from properties file
	@Value("${spring.application.name}")
	static String appName; 
	
	// this main method is optional when deployment is of type 
	// war. this is useful in case you want to test application as stand alone
	// app using java -jar <jarfileName>.war, yes it is war
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
		System.out.println( "Application name -"+appName);
	}
	
	// load static customer data on class load keep it simple
	static {
		customerList = new ArrayList<Customer>();
		customerList.add(new Customer(123,"Rajesh","Hyderabad"));
		customerList.add(new Customer(124,"Atharv","Hyderabad"));
		customerList.add(new Customer(125,"Akshat","Hyderabad"));
	}
	
	// a service to return all customers
	@RequestMapping(value = "/")
	ArrayList <Customer> getCustomers() {
		System.out.println( "Application name -"+appName);
		return customerList;
	}
	
	// return a specific customer data , customer id input
	 @GetMapping("/{id}")
	Customer getCustomer(@PathVariable int id) {
		return customerList.stream()
                .filter(customer -> customer.getId() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("running command runners");
		
	}
	
}
