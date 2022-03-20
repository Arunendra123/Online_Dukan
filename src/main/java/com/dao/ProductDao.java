package com.dao;

import java.util.List;

import com.model.Product;

public interface ProductDao {

	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product);
	public boolean updateProduct(Product product);
	public List<Product> listProduct();
	public Product getProduct(int productId);
}
