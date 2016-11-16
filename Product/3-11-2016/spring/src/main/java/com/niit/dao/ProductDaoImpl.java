package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.CartItem;
import com.niit.model.Category;
import com.niit.model.Customer;
import com.niit.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Product> getAllProducts() {
		Session session = sessionFactory.openSession();
		List<Product> products = session.createQuery("FROM Product").list();
		session.flush();
		session.close();
		
		return products;
	}

	public Product  getProductByproductNumber(int i) {
		// reading the record from the table
		Session session = sessionFactory.openSession();
		// select * from book where isbn=i
		// if we call get method,Record doesnot exist it will return null
		// if we call load, if the record doesnt exist it will throw exception
		Product product = (Product) session.get(Product.class, i);
		session.flush();
		session.close();
		return product;
	}

	public void deleteProduct(int productNumber) {
		Session session = sessionFactory.openSession();
		// select * from book where isbn=?
		Product product = (Product) session.get(Product.class, productNumber);
		// delete from book where isbn=?
		session.delete(product);
		// commit the changes
		// changes to the database will become permanent
		session.flush();
		// closing the connection with the database.
		session.close();// close the session

	}

	@Transactional
	public void  addProduct(Product product) {
		Session session = sessionFactory.openSession();
		session.save(product);
		session.flush();
		session.close();
	}
	public void editProduct(Product product) {
		Session session=sessionFactory.openSession();
		//update bookapp set ....where isbn=?
		session.update(product);
		session.flush();
		session.close();
}

	@SuppressWarnings("unchecked")
	public List<Product> getProductByCategory(int cid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		List<Product> products=session.createQuery("from Product where cid = 1").list();
		return products;
	
/*		List<Category> categories=(List<Category>)Category.getCid();*/
		
	}

}
