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
import org.hibernate.Transaction;

import com.simplilearn.model.Classes;

import com.simplilearn.util.HibernateSessionUtil;

@WebServlet("/add-classes")
public class AddClass extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//request.getRequestDispatcher("index.jsp").include(request, response);
		request.getRequestDispatcher("add-classes.html").include(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//add top nav 
		//request.getRequestDispatcher("index.jsp").include(request, response);

		// fetch data from form
		String ClassName = request.getParameter("classname");
		String ClassRoom = request.getParameter("roomno");
		String ClassSection = request.getParameter("section");
		;

		try {
			// 1. build hibernate session factory
			SessionFactory factory = HibernateSessionUtil.buildSessionFactory();

			// 2. create session object
			Session session = factory.openSession();

			// 3. create a product object
			Classes cl = new Classes(ClassName, ClassRoom,ClassSection);

			// 4. begin transaction
			Transaction tx = session.beginTransaction();

			// 5. save product
			session.save(cl);

			// 6. commit transaction
			tx.commit();

			if(session != null ) {
				out.print("<h3 style='color:green'> Class is Added sucessfully ! </h3>");
			}

			// 3. close session
			session.close();
		} catch (Exception e) {
			out.print("<h3 style='color:red'> Hibernate session is failed ! </h3>");
		}
	}
}
