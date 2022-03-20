package com.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestOnlineDukan {

	public static void main(String args[]) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com");
		annotationConfigApplicationContext.refresh();
	}
}
