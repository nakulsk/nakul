package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CustomerDao;
import com.niit.model.Customer;
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
private CustomerDao customerDao;

	public CustomerDao getCustomerDao() {
	return customerDao;
}

public void setCustomerDao(CustomerDao customerDao) {
	this.customerDao = customerDao;
}
@Transactional
	public void addCustomer(Customer customer) {
		
		customerDao.addCustomer(customer);
	}
public List<Customer> getAllCustomers() {
	return customerDao.getAllCustomers();
}
public Customer getCustomerByUsername (String username){
    return customerDao.getCustomerByUsername(username);
}


}
