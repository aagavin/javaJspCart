package com.AaronFernandes.Assignment2.servlets;

import com.AaronFernandes.Assignment2.controllers.Cart;
import com.AaronFernandes.Assignment2.controllers.Inventory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Aaron Fernandes
 * 300773526
 * -----------
 * Assignment 2
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Inventory inventory = (Inventory) request.getSession().getAttribute("inventory");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		
		if(cart==null){
			cart = new Cart();
			System.out.println("******");
			System.out.println("Setting new cart");
			System.out.println("******");
			request.getSession().setAttribute("cart",cart);
		}
		int quanity = Integer.parseInt(request.getParameter("quantity"));
		String sku = request.getParameter("sku");
		
		cart.addItem(sku, quanity);
		inventory.decrementItem(sku,quanity);
		
		request.setAttribute("cart", cart);
		request.setAttribute("inventory",inventory);
		//
		response.setContentType("text/html");
		request.getRequestDispatcher("cart.jsp").forward(request, response);
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("\n\nHey*****************\n\n");
	}
}
