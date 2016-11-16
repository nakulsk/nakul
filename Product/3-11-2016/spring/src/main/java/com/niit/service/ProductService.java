package com.niit.service;

import java.util.List;

import com.niit.model.Product;

public interface ProductService {
	List<Product> getAllProducts();
	Product getProductByproductNumber(int productNumber);
	void deleteProduct(int isbn);
    void addProduct(Product product);
    void editProduct(Product product);
	List<Product> getProductByCategory(int cid);

}
