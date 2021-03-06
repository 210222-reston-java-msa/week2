package com.example.sessionservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Supervillain;

/**
 * Servlet implementation class SessionServlet
 */
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public SessionServlet() {
        super();
	}
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Supervillain muddy = new Supervillain("Mud Man", "Mud Armor", 100000);

		/*
		 * The HttpSession interface provides a way to identify a user accross more than
		 * just one page request or visit to a web site and to store info about that
		 * user. This makes User experience (UX) better
		 * 
		 * This doGet() method is using this interface to create a session between
		 */
		HttpSession session = request.getSession();

		session.setAttribute("villain", muddy);

		PrintWriter out = response.getWriter();
		out.write(new ObjectMapper().writeValueAsString(muddy));
		out.println("Mud man is on the loose and the session is set"); // this will print to the screen
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//When I hit doPost(), I send a POST method to this servlet, I CREATE a new villain object
		//Step 1. Capture parameters
		String name = request.getParameter("name");
		String superpower = request.getParameter("superpower");
		int bounty = Integer.parseInt(request.getParameter("bounty")); //transforming "120" --> 120 as an int
		
		//Step 2. Us the captured params to build a supervillain obj
		Supervillain tempVill = new Supervillain(name, superpower, bounty);
		
		// Grab the HttpSession obj from the request with getSession()
		HttpSession session = request.getSession();
		
		//4. Set the "villain attribute = to the custom villain (tempVill)
		session.setAttribute("villain", tempVill);
		
		//5. Print to the screen that a villain is on the loose
		PrintWriter out = response.getWriter();
		out.println("A villain is on the loose... <br />");
		out.println(new ObjectMapper().writeValueAsString(tempVill.getName()));
		
		//then I open an HttpSession obj... and I SET THE ATTRIBUTE	as session.setATtribute("villain",tempVillain)

}

}
