package com.niit.service;

import java.util.List;

import com.niit.model.Customer;

public interface CustomerService {
void addCustomer(Customer customer);
List<Customer> getAllCustomers();
Customer getCustomerByUsername(String username);
}


