package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;
//@Repistory is always applied to DAO 

@Repository
public class CustomerDAOImpl implements CustomerDAO { 

	
	// Need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory; // Session factory connects to the XML
	
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		
		// get the current hibernate session that is open
		Session currentSession = sessionFactory.getCurrentSession(); //Injected into the DAO for us. Using session object from 
		// hiberate package
		
		// create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		
		
		// get the result list, or get a list of customers from a query (execute and  get result list)
		List<Customer> customers = theQuery.getResultList();
		
		
		// return the list of customers that have been retrieved
		return customers;
	}

}




