package com.niit.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.BillingAddress;
import com.niit.model.Customer;
import com.niit.model.ShippingAddress;
import com.niit.model.Users;
import com.niit.service.CustomerService;


@Controller
public class RegistrationController {
@Autowired
//dependency injection
private CustomerService customerService;



public CustomerService getCustomerServices() {
	return customerService;
}
public void setCustomerServices(CustomerService customerService) {
	this.customerService = customerService;
}
//To display registration form
	//when the user makes the request by the url  /customer/registration (get)
@RequestMapping("/customer/registration")
public ModelAndView getRegistrationForm(){
	Customer customer=new Customer();
	Users users=new Users();
	BillingAddress billingAddress=new BillingAddress();
	ShippingAddress shippingAddress=new ShippingAddress();
	
	customer.setUsers(users);
	customer.setBillingAddress(billingAddress);
	customer.setShippingAddress(shippingAddress);
	
	return new ModelAndView("registrationCustomer","customer",customer);
	
}
//to insert the data 
@RequestMapping(value="/customer/registration",method=RequestMethod.POST)
public String registerCustomer(@Valid @ModelAttribute(value="customer")Customer customer,
		Model model,
		BindingResult result){
	if(result.hasErrors())
		return "registrationCustomer";
	customerService.addCustomer(customer);
	model.addAttribute("registrationSuccess","Registered Successfully. Login using username and password");
	return "login";
}
}

