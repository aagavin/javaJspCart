package com.AaronFernandes.Assignment2.servlets;

import com.AaronFernandes.Assignment2.Inventory;
import com.AaronFernandes.Assignment2.models.Item;

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

//		Map<String, String[]> params = request.getParameterMap();
//		for (Map.Entry<String, String[]> entry: params.entrySet()){
//			System.out.println(entry.getKey()+" - "+ Arrays.toString(entry.getValue()));
//		}
//
		int index =1;
		Inventory i = (Inventory) request.getSession().getAttribute("inventory");
		for (Item item : i.getItems()){

			System.out.println(index+") "+item.getName());
			index++;
		}
		response.setContentType("text/html");
		request.getRequestDispatcher("cart.jsp").forward(request, response);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("\n\nHey*****************\n\n");
	}
}
