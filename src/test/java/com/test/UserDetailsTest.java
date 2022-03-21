package com.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.CategoryDao;
import com.dao.UserDetailsDao;
import com.model.Category;
import com.model.UserDetails;

public class UserDetailsTest {

private static UserDetailsDao userDetailsDao;
	
	@BeforeClass
	public static void excuteFirst() {
		AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com");
		annotationConfigApplicationContext.refresh();
		userDetailsDao=annotationConfigApplicationContext.getBean("userDetailsDao",UserDetailsDao.class);
	}

	@Test
	public void addUserDetailsTest() {
		UserDetails userDetails=new UserDetails();
		userDetails.setUsername("test1");
		userDetails.setPassword("test");
		userDetails.setRole("Test");
		userDetails.setCustomerName("Ram");
		userDetails.setCustomerAddress("Delhi");
		assertTrue("Problem in adding user",userDetailsDao.addUserDetails(userDetails));
	}
	
	@Test
	public void deleteUserDetailsTest() {
		UserDetails userDetails=new UserDetails();
		userDetails.setUsername("test1");
		userDetails.setPassword("test");
		userDetails.setRole("Test");
		userDetails.setCustomerName("Ram");
		userDetails.setCustomerAddress("Delhi");
		assertTrue("Problem in deleting user",userDetailsDao.deleteUserDetails(userDetails));
	}
}
