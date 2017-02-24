package com.AaronFernandes.Assignment2.controllers;

import java.util.HashMap;
import java.util.Map;

/**
 * Aaron Fernandes
 * 300773526
 * -----------
 * Assignment 2
 */
public class Cart {
	private Map<String, Integer> _cartItems;
	
	public Cart(){
		this._cartItems = new HashMap<>();
	}
	
	public void addItem(String sku, int value){
		this._cartItems.put(sku,value);
	}
	
	public void updateItemCount(String sku, int value){
		this.addItem(sku,value);
	}
	
	public Map<String, Integer> get_cartItems() {
		return this._cartItems;
	}
}
