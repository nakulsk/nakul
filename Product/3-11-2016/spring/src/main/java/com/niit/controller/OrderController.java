package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.model.Cart;
import com.niit.model.Customer;
import com.niit.model.CustomerOrder;
import com.niit.service.CartService;
import com.niit.service.CustomerOrderService;

@Controller
public class OrderController {
	@Autowired
	private CartService cartService;

	@Autowired
	private CustomerOrderService customerOrderService;

	@RequestMapping("/order/{cartId}")
	public String createOrder(@PathVariable("cartId") int cartId) {
		System.out.println("reached1");
		CustomerOrder customerOrder = new CustomerOrder();
		System.out.println(customerOrder.getCustomerOrderId());		System.out.println("reached2");
		Cart cart = cartService.getCartByCartId(cartId);
		// UPDATE CARTID FOR CUSTOMERORDER - SET CARTID
		customerOrder.setCart(cart);
		System.out.println("reached");
		Customer customer = cart.getCustomer();
		// SET CUSTOMERID
		customerOrder.setCustomer(customer);
		// SET BILLINGADDRESSID
		customerOrder.setBillingAddress(customer.getBillingAddress());
		// SET SHIPPINGADDRESSID
		customerOrder.setShippingAddress(customer.getShippingAddress());

		customerOrderService.addCustomerOrder(customerOrder);
		System.out.println("reached destiny");
		System.out.println(customerOrder.getCustomerOrderId());	
		return "redirect:/checkout?cartId=" + cartId;

	}

}
