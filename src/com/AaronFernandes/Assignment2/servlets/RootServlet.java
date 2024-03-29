package com.AaronFernandes.Assignment2.servlets;

import com.AaronFernandes.Assignment2.beans.Inventory;

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
 *
 * This is the main servlet that loads when
 */
@WebServlet(name = "rootServlet", urlPatterns = "")
public class RootServlet extends HttpServlet {
	
	/**
	 * Handles the post request to the root endpoint
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws ServletException thrown when there is an error in the exception
	 * @throws IOException thrown when there is an error in IO
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath());
	}
	
	/**
	 * Handles the get request to the root endpoint
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws ServletException thrown when there is an error in the exception
	 * @throws IOException thrown when there is an error in IO
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Inventory inventory = (Inventory) request.getSession().getAttribute("inventory");
		
		if (inventory==null){
			inventory=new Inventory();
		}
		request.getSession().setAttribute("inventory", inventory);
		
		
		request.setAttribute("inventory", inventory);
		response.setContentType("text/html");
		request.getRequestDispatcher("root.jsp").forward(request, response);
	}
}
