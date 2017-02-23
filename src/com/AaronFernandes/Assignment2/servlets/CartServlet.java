package com.AaronFernandes.Assignment2.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * Aaron Fernandes
 * 300773526
 * -----------
 * Assignment 2
 */
@WebServlet(name = "CartServlet", urlPatterns = "cart")
public class CartServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<String> headerArrayList = new ArrayList<String>();
		ArrayList<String[]> dataArrayList = new ArrayList<String[]>();
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			headerArrayList.add(paramName);
			
			String[] paramValues = request.getParameterValues(paramName);
			dataArrayList.add(paramValues);
			
			System.out.println(paramName+" - "+ Arrays.toString(paramValues));
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("\n\nHey*****************\n\n");
	}
}
