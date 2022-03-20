package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue
	private int prouctId;
	private String productName;
	private String productDescription;
	private int price;
	private int categoryId;
	private int stock;
	private int supplierId;
	public int getProuctId() {
		return prouctId;
	}
	public void setProuctId(int prouctId) {
		this.prouctId = prouctId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	@Override
	public String toString() {
		return "Product [prouctId=" + prouctId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", price=" + price + ", categoryId=" + categoryId + ", stock=" + stock
				+ ", supplierId=" + supplierId + "]";
	}
}
