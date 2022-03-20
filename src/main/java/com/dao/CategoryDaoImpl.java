package com.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
			System.out.print("--------------Category added--------------");
		} catch(Exception e) {
			System.out.print("--------------Category have not been added--------------");
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().delete(category);
		} catch(Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean updateCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
		} catch(Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public List<Category> listCategory() {
	   Session session=sessionFactory.openSession();
	   CriteriaQuery<Category> criteriaQuery=session.getCriteriaBuilder().createQuery(Category.class);
	   Root<Category> root=criteriaQuery.from(Category.class);
	   criteriaQuery.select(root);
	   List<Category> categories=session.createQuery(criteriaQuery).list();
	   session.close();
	   return categories;
	}

	@Override
	public Category getCategory(int categoryId) {
		   Session session=sessionFactory.openSession();
		   CriteriaQuery<Category> criteriaQuery=session.getCriteriaBuilder().createQuery(Category.class);
		   Root<Category> root=criteriaQuery.from(Category.class);
		   criteriaQuery.select(root).where(root.get("categoryId").in(categoryId));
		   Category category=session.createQuery(criteriaQuery).uniqueResult();
		   session.close();
		   return category;
	}
}
