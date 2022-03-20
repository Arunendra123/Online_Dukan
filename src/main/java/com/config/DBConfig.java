package com.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.model.Category;

@Configuration
@EnableTransactionManagement
public class DBConfig {

	@Bean(name="dataSource")
	public DataSource getPostgressDataSource() {
		DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
		driverManagerDataSource.setUsername("soar");
		driverManagerDataSource.setPassword("soar123");
		driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
		driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
		System.out.println("-------------------Datasource Configured---------------");
		return driverManagerDataSource;
	}
	
	@Bean(name="sessionFactory") 
	public SessionFactory getSessionFactory() {
		Properties properties=new Properties();
		properties.put("hibernate.hbm2ddl.auto","update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(getPostgressDataSource());
		localSessionFactoryBuilder.addProperties(properties);
		localSessionFactoryBuilder.addAnnotatedClass(Category.class);
		System.out.println("-------------------Session Factory created---------------");
		return localSessionFactoryBuilder.buildSessionFactory();
	}
	
	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		System.out.println("----------------Transaction Manager Configured---------------");
		return new HibernateTransactionManager(sessionFactory);
	}
}
