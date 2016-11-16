package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.ProductDao;
import com.niit.model.*;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDao;

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	public Product getProductByproductNumber(int productNumber) {
		return productDao.getProductByproductNumber(productNumber);
	}

	public void deleteProduct(int productNumber) {
		productDao.deleteProduct(productNumber);

	}

	public void  addProduct(Product product){
		productDao.addProduct(product);
	}
	public void editProduct(Product product) {
		productDao.editProduct(product);
		
	}

	public List<Product> getProductByCategory(int cid) {
		return productDao.getProductByCategory(cid);

	}


}
