package com.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.UserDetails;

@Repository("userDetailsDao")
@Transactional
public class UserDetailsDaoImpl implements UserDetailsDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addUserDetails(UserDetails userDetails) {
		try {
			sessionFactory.getCurrentSession().save(userDetails);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteUserDetails(UserDetails userDetails) {
		try {
			sessionFactory.getCurrentSession().delete(userDetails);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateUserDetails(UserDetails userDetails) {
		try {
			sessionFactory.getCurrentSession().update(userDetails);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<UserDetails> listUserDetails() {
		Session session=sessionFactory.openSession();
		CriteriaQuery<UserDetails> criteriaQuery=session.getCriteriaBuilder().createQuery(UserDetails.class);
		Root<UserDetails> root=criteriaQuery.from(UserDetails.class);
		criteriaQuery.select(root);
		List<UserDetails> userDetails=session.createQuery(criteriaQuery).list();
		
		return userDetails;
	}

	@Override
	public UserDetails getUserDetails(String username) {
		Session session=sessionFactory.openSession();
		CriteriaQuery<UserDetails> criteriaQuery=session.getCriteriaBuilder().createQuery(UserDetails.class);
		Root<UserDetails> root=criteriaQuery.from(UserDetails.class);
		criteriaQuery.select(root).where(root.get("username").in(username));
		UserDetails userDetails=session.createQuery(criteriaQuery).uniqueResult();
		return userDetails;
	}
}
