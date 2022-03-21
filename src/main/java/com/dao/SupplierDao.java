package com.dao;

import java.util.List;

import com.model.Supplier;

public interface SupplierDao {

	public boolean addSupplier(Supplier supplier) ;
	public boolean deleteSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public List<Supplier> listSupplier();
	public Supplier getSupplier(int categoryId);
}
