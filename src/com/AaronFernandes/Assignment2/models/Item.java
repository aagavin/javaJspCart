package com.AaronFernandes.Assignment2.models;

/**
 * Aaron Fernandes
 * 300773526
 * -----------
 * Assignment 2
 */
public class Item {
	private String name;
	private String sku;
	private String description;
	private int stock;
	private double price;
	private String imgurl;
	
	public Item(String name, String sku, String description, int stock, double price, String imgurl) {
		this.name = name;
		this.sku = sku;
		this.description = description;
		this.stock = stock;
		this.price = price;
		this.imgurl = imgurl;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSku() {
		return sku;
	}
	
	public void setSku(String sku) {
		this.sku = sku;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getImgurl() {
		return imgurl;
	}
	
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
}
