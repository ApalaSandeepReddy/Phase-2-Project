package com.simplilearn.web;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.simplilearn.util.HibernateSessionUtil;

@WebServlet("/init-session")
public class InitializeSession extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.jsp").include(request, response);

		try {
			// 1. build hibernate session factory
			SessionFactory factory = HibernateSessionUtil.buildSessionFactory();

			// 2. create session object
			Session session = factory.openSession();

			if(session != null ) {
				out.print("<h3 style='color:green'> Data base Conncetion  is created sucessfully ! </h3>");

			}

			// 3. close session
			session.close();
		} catch (Exception e) {
			out.print("<h3 style='color:red'> Database Conncetion is failed ! </h3>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
