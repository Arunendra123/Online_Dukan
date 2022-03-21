package com.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.SupplierDao;
import com.model.Supplier;

public class SupplierTest {

private static SupplierDao supplierDao;
	
	@BeforeClass
	public static void excuteFirst() {
		AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com");
		annotationConfigApplicationContext.refresh();
		supplierDao=annotationConfigApplicationContext.getBean("supplierDao",SupplierDao.class);
	}

	@Test
	public void addSupplierTest() {
		Supplier supplier=new Supplier();
		supplier.setSupplierName("Addidas");
		supplier.setSupplierAddress("Mumbai");
		assertTrue("Problem in adding Supplier",supplierDao.addSupplier(supplier));
	}
	
	@Test
	public void deleteSupplierTest() {
		Supplier supplier=new Supplier();
		supplier.setSupplierName("Addidas");
		supplier.setSupplierAddress("Mumbai");
		assertTrue("Problem in deleting Supplier",supplierDao.deleteSupplier(supplier));
	}
}
