package com.revature.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.revature.models.Employee;
import com.revature.services.EmployeeService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(LoginServlet.class);
	
	LoginServlet() {
    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// we will have an index.html with a form section/login section and upon clicking the button,
		// it will send a POST request to THIS servlet
		
		//1. We handle the parameters from the index
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		log.info("user attempted to login with the username " + username);
		
		//2. Create an Employee ojb to capture the data from DB
		Employee e = EmployeeService.confirmLogin(username, password);
		
		//3. Set an attribute for the session to remember the user
		if (e != null) {
			HttpSession session = request.getSession();
			
			session.setAttribute("username", username);
			
			RequestDispatcher rd = request.getRequestDispatcher("home.html"); //we will create this .. this welcomes the user upon successful login
			
			rd.forward(request, response);
			log.info(username + " has successfully logged in");
		
		} else {
			log.info(username + " has failed to log in");
			//we will expand upon this and create a failure page later and redirect the user there
		}
		
		//4. Redirect the user to the home page because they successfuly logged in.
		
	}

}
