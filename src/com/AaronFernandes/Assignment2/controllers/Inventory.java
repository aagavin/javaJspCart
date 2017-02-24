package com.AaronFernandes.Assignment2.controllers;

import com.AaronFernandes.Assignment2.models.Item;

import java.util.ArrayList;

/**
 * Aaron Fernandes
 * 300773526
 * -----------
 * Assignment 2
 */
public class Inventory {
	private ArrayList<Item> _items;
	
	public Inventory() {
		_items = new ArrayList<>();
		
		_items.add(new Item("ASUS Bilingual Gaming Notebook","2A-0E-25-16","New ASUS Notebook, A perfect balance of power and portability",5,2310.34, "https://images10.newegg.com/ProductImage/34-234-333-18.jpg"));
		_items.add(new Item("Acer Aspire Laptop","1A-2R-5F-Q2","The Acer Aspire E5-553G-1986 is a great everyday laptop that delivers performance, features and design at a great price.",1,512.25, "https://images10.newegg.com/ProductImage/34-315-445-S01.jpg"));
		_items.add(new Item("Lenovo Laptop IdeaPad 510","L2-E3-P1-F3","Lenovo Laptop IdeaPad 510 is a powerful laptop for work and play.",8,999.99, "https://images10.newegg.com/ProductImage/34-332-305-03.jpg"));
		_items.add(new Item("DELL Laptop XPS","4Q-1F-3R-Y1","The DELL XPS 13 sets a new standard for 13\" laptops with excellent performance, an attractive design and premium build in a sleek, elegant compact package.",15,1249.99,"https://images10.newegg.com/ProductImage/34-295-406-07.jpg"));
		_items.add(new Item("HP Chromebook 11 G5","X9-U0-2U-4T","Inspire learning and help elevate productivity to the next level with HP Chromebook 11.",7,259.12,"https://images10.newegg.com/ProductImage/34-266-278CVF-03.jpg"));
		_items.add(new Item("Toshiba Satellite Pro","R3-3W-Q5-56","8 GB DDR3L SDRAM RAM - 1 TB HDD - Intel HD Graphics 520 DDR3L SDRAM - Windows 10 - 1366 x 768 16:9 Display - Bluetooth - English, French Keyboard ",25,710.34,"https://images10.newegg.com/NeweggImage/ProductImage/A4FT_1_201609141610489272.jpg"));
	}
	
	public ArrayList<Item> get_items() {
		return _items;
	}
	
	public Item getItemBySku(String sku){
		for (Item item : this._items){
			if ((item.getSku().equals(sku))){
				return item;
			}
		}
		return null;
	}
	
	public void decrementItem(String sku,int decAmount){
		for (int i =0; i<this._items.size();i++){
			if ((this._items.get(i).getSku().equals(sku))){
				this._items.get(i).setStock(this._items.get(i).getStock()-decAmount);
			}
		}
		
		
	}
	
}
