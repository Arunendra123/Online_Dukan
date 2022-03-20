package com.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.CategoryDao;
import com.dao.ProductDao;
import com.model.Product;

public class ProductTest {

    private static ProductDao productDao;
	
	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com");
		annotationConfigApplicationContext.refresh();
		productDao=annotationConfigApplicationContext.getBean("productDao",ProductDao.class);
	}
	
	@Test
	public void addProductTest() {
		Product product=new Product();
		product.setProductName("Full Sleeve T-Shirt");
		product.setProductDescription("Color: Red");
		product.setPrice(400);
		product.setSupplierId(1);
		product.setCategoryId(2);
		product.setStock(4);
		assertTrue("Problem in adding product", productDao.addProduct(product));
	}
}
