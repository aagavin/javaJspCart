package com.AaronFernandes.Assignment2.servlets;

import com.AaronFernandes.Assignment2.beans.Cart;
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
 */


// shopping cart servlet
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	
	/**
	 * Handle post request to the /cart endpoint
	 * @param request http request
	 * @param response http response
	 * @throws ServletException thrown when there is an error in the exception
	 * @throws IOException thrown when there is an error in IO
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get the inventory bean from the session
		Inventory inventory = (Inventory) request.getSession().getAttribute("inventory");
		// get the cart bean from the session
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		
		// if there is no cart create a new cart
		// then add the new cart to the session
		if(cart==null){
			cart = new Cart();
			request.getSession().setAttribute("cart",cart);
		}
		
		//get sku and quantity from the post request
		String sku = request.getParameter("sku");
		int quality = Integer.parseInt(request.getParameter("quantity"));
		
		// if the item is in the cart update the count
		// else add a new item
		if (cart.isItemInCart(sku)){
			cart.updateItemCount(sku,quality);
		}
		else {
			cart.addItem(sku, quality);
		}
		
		// update inventory count
		inventory.decrementItem(sku,quality);
		
		// add attributes to the request
		request.setAttribute("cart", cart);
		request.setAttribute("inventory",inventory);
		
		// displays the view
		response.setContentType("text/html");
		request.getRequestDispatcher("cart.jsp").forward(request, response);
		
	}
	
	/**
	 * Handle get request for the
	 * /cart endpoint
	 *
	 * @param request http request
	 * @param response http response
	 * @throws ServletException thrown when there is an error in the exception
	 * @throws IOException thrown when there is an error in IO
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// redirects the user to the root view
		response.sendRedirect(request.getContextPath());
	}
}
