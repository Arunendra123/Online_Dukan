package com.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Supplier;

@Repository("supplierDao")
@Transactional
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().save(supplier);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public boolean deleteSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().delete(supplier);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public boolean updateSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public List<Supplier> listSupplier() {
		Session session=sessionFactory.openSession();
		CriteriaQuery<Supplier> criteriaQuery=session.getCriteriaBuilder().createQuery(Supplier.class);
		Root<Supplier> root=criteriaQuery.from(Supplier.class);
		criteriaQuery.select(root);
		List<Supplier> suppliers=session.createQuery(criteriaQuery).list();
		return suppliers;
	}

	@Override
	public com.model.Supplier getSupplier(int categoryId) {
		Session session=sessionFactory.openSession();
		CriteriaQuery<Supplier> criteriaQuery=session.getCriteriaBuilder().createQuery(Supplier.class);
		Root<Supplier> root=criteriaQuery.from(Supplier.class);
		criteriaQuery.select(root).where(root.get("categoryId").in(categoryId));
		Supplier supplier=session.createQuery(criteriaQuery).uniqueResult();
		return supplier;
	}
}
