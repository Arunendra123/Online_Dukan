package com.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Product;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} 
		return true;
	}

	@Override
	public List<Product> listProduct() {
		Session session=sessionFactory.openSession();
		CriteriaQuery<Product> criteriaQuery=session.getCriteriaBuilder().createQuery(Product.class);
		Root<Product> root=criteriaQuery.from(Product.class);
		criteriaQuery.select(root);
		List<Product> products=session.createQuery(criteriaQuery).list();
		session.close();
		return products;
	}

	@Override
	public Product getProduct(int productId) {
		Session session=sessionFactory.openSession();
		CriteriaQuery<Product> criteriaQuery=session.getCriteriaBuilder().createQuery(Product.class);
		Root<Product> root=criteriaQuery.from(Product.class);
		criteriaQuery.select(root).where(root.get("productId").in(productId));
		Product product=session.createQuery(criteriaQuery).uniqueResult();
		session.close();
		return product;
	}
}
