package com.niit.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cartitem")
public class CartItem {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int cartItemId;
private int quantity;
private double Totalprice;
@ManyToOne
@JoinColumn(name="isbn")
private Book book;
@ManyToOne
@JoinColumn(name="cartid")
@JsonIgnore
private Cart cart;
public int getCartItemId() {
	return cartItemId;
}
public void setCartItemId(int cartItemId) {
	this.cartItemId = cartItemId;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public double getTotalprice() {
	return Totalprice;
}
public void setTotalprice(double totalprice) {
	Totalprice = totalprice;
}
public Book getBook() {
	return book;
}
public void setBook(Book book) {
	this.book = book;
}
public Cart getCart() {
	return cart;
}
public void setCart(Cart cart) {
	this.cart = cart;
}

}