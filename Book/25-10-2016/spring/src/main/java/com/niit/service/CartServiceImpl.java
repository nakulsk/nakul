package com.niit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.CartDao;
import com.niit.model.Cart;
@Service
public class CartServiceImpl implements CartService{
@Autowired
private CartDao cartDao;

	public CartDao getCartDao() {
	return cartDao;
}
public void setCartDao(CartDao cartDao) {
	this.cartDao = cartDao;
}
public Cart getCartByCartId(int cartId) {
		return cartDao.getCartByCartId(cartId);
	}
}

