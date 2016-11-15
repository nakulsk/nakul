package com.niit.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.niit.model.Book;
import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Customer;
import com.niit.service.BookService;
import com.niit.service.CartItemService;
import com.niit.service.CartService;
import com.niit.service.CustomerService;



@Controller
public class CartItemController {
@Autowired
private CartItemService cartItemService;
@Autowired
private CustomerService customerService;
@Autowired
private BookService bookService;
@Autowired
private CartService cartService;

public CartItemService getCartItemService() {
	return cartItemService;
}


public void setCartItemService(CartItemService cartItemService) {
	this.cartItemService = cartItemService;
}


public CustomerService getCustomerService() {
	return customerService;
}


public void setCustomerService(CustomerService customerService) {
	this.customerService = customerService;
}


public BookService getBookService() {
	return bookService;
}


public void setBookService(BookService bookService) {
	this.bookService = bookService;
}

@RequestMapping("/cart/add/{isbn}")
@ResponseStatus(value=HttpStatus.NO_CONTENT)
public void addCartItem(@PathVariable(value="isbn") int isbn){
	//Is to get the username of the customer
	//User object contains details about the user -username , password, activeuser or not
	User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String username=user.getUsername();
	Customer customer=customerService.getCustomerByUsername(username);
	System.out.println("Customer is " + customer.getCustomerEmail() );
	Cart cart=customer.getCart();
	
	List<CartItem> cartItems=cart.getCartItem();
	Book book=bookService.getBookByIsbn(isbn);
	for(int i=0;i<cartItems.size();i++){
		CartItem cartItem=cartItems.get(i);
		if(book.getIsbn()==cartItem.getBook().getIsbn()){
			cartItem.setQuantity(cartItem.getQuantity() + 1);
			cartItem.setTotalprice(cartItem.getQuantity() * book.getPrice());
	//		cart.setTotalPrice(cartItem.getPrice();
			cartItemService.addCartItem(cartItem);
			return;
		}
	}
	CartItem cartItem=new CartItem();
	cartItem.setQuantity(1);
	cartItem.setBook(book);
	cartItem.setTotalprice(book.getPrice() * 1);
	cartItem.setCart(cart);
	cartItemService.addCartItem(cartItem);
	
	
}
@RequestMapping("/cart/removecartitem/{cartItemId}")
@ResponseStatus(value=HttpStatus.NO_CONTENT)
public void removeCartItem(
	@PathVariable(value="cartItemId") int cartItemId){
	cartItemService.removeCartItem(cartItemId);
}

@RequestMapping("/cart/removeAllItems/{cartId}")
@ResponseStatus(value=HttpStatus.NO_CONTENT)
public void removeAllCartItems(@PathVariable(value="cartId") int cartId){
	Cart cart=cartService.getCartByCartId(cartId);
	cartItemService.removeAllCartItems(cart);
}




}

