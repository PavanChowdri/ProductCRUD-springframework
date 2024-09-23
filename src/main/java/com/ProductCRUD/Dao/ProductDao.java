package com.ProductCRUD.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ProductCRUD.Model.Product;

import jakarta.transaction.Transactional;
import java.util.*;

@Component
public class ProductDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	//create
	@Transactional
	public void createProduct(Product product) {
		this.getSession().saveOrUpdate(product);
	}
	
	//getAllProducts
	@Transactional
	public List<Product> getProducts(){
		String query="From Product";
		List<Product> products=this.getSession().createQuery(query,Product.class).getResultList();
		return products;
	}
	
	//Delete
	@Transactional
	public void deleteProduct(int pid) {
		Product product=this.getSession().get(Product.class, pid);
		this.getSession().delete(product);
	}
	
	//Get single product
	@Transactional
	public Product getProduct(int pid) {
		Product product=this.getSession().get(Product.class, pid);
		return product;
	}
	

	
	
}
