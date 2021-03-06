package com.example.directservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Supervillain;


public class DirectServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private Logger log = Logger.getLogger(DirectServlet.class);
	
	/* 
	 * 3 Steps to create a Servlet
	 * 
	 * Step 1: create a class that inherits from HttpServlet or GenericServlet
	 * 
	 * Step 2: Override that doGet and doPOst methods()
	 * 	- we do NOT override the init() methods (abstracted)
	 * 
	 * Step 3: configure the servlet in your web.xml (Deployment Descriptor)
	 */
	
	//This is happening in the background
//	public void init() throws ServletException {}
		
	// this method allows a Servlet to handle a GET request
	//*********************************MEMORIZE THIS*******************************************************
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		//When this servlet receives a get request, I want it to simply write to the browser, "Hey!"
		res.setContentType("text/html");
		
		//PrintWriter is an object that prints text data to a char stream
		//we can call it on the response
		PrintWriter out = res.getWriter();
		out.println("<html><body><h1>The Servlet is talking directly to the client:</h1></body></html>");
		
		
		log.info("Inside the directServlet doGet() method");
		
	}
	
	//We hit this method with a POST request from Postman at the http//localhost
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		// the object that I send back will correspond to an object that I've define a CLASS for in my java app
		res.setContentType("application/json");
		
		//1. create a supervillan
		
		Supervillain sheev = new Supervillain("Sheev Palpatine", "Evilness", 260000 );
		
		//2. Send this supervillan as a JSON object to the browser
		
		res.getWriter().write(new ObjectMapper().writeValueAsString(sheev));

		log.info("were in the post method");
	}

}
