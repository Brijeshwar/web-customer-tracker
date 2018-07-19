package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//Inject the customer dao
	@Autowired
	private CustomerDAO customerDAO;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		//Get the customers from the dao
		List<Customer> theCustomers = customerDAO.getCustomers();
		
		//Add customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
}
