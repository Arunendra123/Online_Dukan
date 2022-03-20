package com.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.CategoryDao;
import com.model.Category;

public class CategoryTest {

	private static CategoryDao categoryDao;
	
	@BeforeClass
	public static void excuteFirst() {
		AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com");
		annotationConfigApplicationContext.refresh();
		categoryDao=annotationConfigApplicationContext.getBean("categoryDao",CategoryDao.class);
	}

	@Test
	public void addCategoryTest() {
		Category category=new Category();
		category.setCategoryName("T-Shirt");
		category.setCategoryDescription("All Variety t-shirt");
		assertTrue("Problem in adding category",categoryDao.addCategory(category));
	}
	
	@Test
	public void deleteCategoryTest() {
		Category category=new Category();
		category.setCategoryName("T-Shirt");
		category.setCategoryDescription("All Variety t-shirt");
		assertTrue("Problem in deleting category",categoryDao.deleteCategory(category));
	}
}
