package com.dao;

import java.util.List;

import com.model.Category;

public interface CategoryDao{
	
	public boolean addCategory(Category category) ;
	public boolean deleteCategory(Category category);
	public boolean updateCategory(Category category);
	public List<Category> listCategory();
	public Category getCategory(int categoryId);
}
