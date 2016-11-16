package com.niit.dao;

import java.util.List;

import com.niit.model.Product;

public interface ProductDao {
	List<Product> getAllProducts();

	Product getProductByproductNumber(int productNumber);

	void deleteProduct(int productNumber);

	void addProduct(Product product);
	void editProduct(Product product);

	List<Product> getProductByCategory(int cid);

}