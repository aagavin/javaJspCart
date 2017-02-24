package com.AaronFernandes.Assignment2.beans;

import java.util.HashMap;
import java.util.Map;

/**
 * Aaron Fernandes
 * 300773526
 * -----------
 * Assignment 2
 *
 * Cart bean.
 * This class holds data for the cart
 */
public class Cart {
	private Map<String, Integer> _cartItems;
	
	/**
		Creates a new cart item
	 */
	public Cart(){
		this._cartItems = new HashMap<>();
	}
	
	/**
	 * Adds a new item in the class 
	 * @param sku
	 * @param value
	 */
	public void addItem(String sku, int value){
		this._cartItems.put(sku,value);
	}
	
	/**
	 * Checks to see if an item is in a cart
	 * @param sku
	 * @return
	 */
	public boolean isItemInCart(String sku){
		for (String key : this._cartItems.keySet()) {
			if (key.equals(sku)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Updates an item in the cart
	 * @param sku
	 * @param value
	 */
	public void updateItemCount(String sku, int value){
		this.addItem(sku, this._cartItems.get(sku)+value);
	}
	
	/**
	 *
	 * @return gets the cart
	 */
	public Map<String, Integer> get_cartItems() {
		return this._cartItems;
	}
}
