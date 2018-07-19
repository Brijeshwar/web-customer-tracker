package com.luv2code.springdemo.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//Inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		//Get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//Create a query
		Query<Customer> query = session.createQuery("from Customer", Customer.class);
		
		//Execute quey and get the result list
		List<Customer> theCustomers = query.getResultList(); 
				
		//return the results
		return theCustomers;
	}

}
