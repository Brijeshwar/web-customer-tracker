package com.luv2code.springdemo.controller;

import java.util.List;

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
	public List<Customer> getCustomers() {
		
		//Get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//Create a query and sort by last name
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
		
		//Execute quey and get the result list
		List<Customer> theCustomers = query.getResultList(); 
				
		//return the results
		return theCustomers;
	}
	
	@Override
	public void saveCustomer(Customer theCustomer) {
		
		//Get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//Save or update the customer
		session.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int customerId) {
		
		//Get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//Get the customer from database using the primary key
		Customer theCustomer = session.get(Customer.class, customerId);
		
		return theCustomer;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteCustomer(int customerId) {
		
		//Get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//Delete the object with the primary key
		Query<Customer> query = session.createQuery("delete from Customer where id=:custId");
		query.setParameter("custId", customerId);
		
		query.executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Customer> searchCustomers(String theSearchName) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        // only search by name if theSearchName is not empty
        if (theSearchName != null && theSearchName.trim().length() > 0) {
            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

        } else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from Customer", Customer.class);            
        }
        
        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();
                
        // return the results        
        return customers;
        
    }

}
