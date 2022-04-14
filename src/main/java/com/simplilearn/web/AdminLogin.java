package com.simplilearn.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")

public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		//request.getRequestDispatcher("index.jsp").include(request, response);	
		request.getRequestDispatcher("login.html").include(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub



		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		String useremail=request.getParameter("UserEmail");
		String userpassword=request.getParameter("UserPassword");


		if(useremail.equals("")  ||  userpassword.equals(""))
		{
			out.println("<h1 style='color:red '>Login Failed ! ** Required filed is missing </h1>");
		}
		else
			if(useremail.equals("admin@gmail.com")  && userpassword.equals("admin@123"))
		{
				//out.println("<h1 style='color:green '>Login Successfully ! **  </h1>");
				//out.println("<a href='add-student'  >Add Student || </a> ");
				//out.println("<a href='add-teacher'>Add Teachers ||</a>");
				//out.println("<a href='add-classes'>Add Classes ||</a>");
				//out.println("<a href='add-subject'>Add Subjects ||</a>");
				//out.print("<a href='index'>Index</a>");
				request.getRequestDispatcher("admin.jsp").include(request, response);


		}
		else
		{
			out.println("<h1 style='color:red '>Login Failed ! ** Creadentails are Invalid </h1>");
		}


	}

}
