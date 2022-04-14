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

//import com.simplilearn.webapp.model.Classes;
import com.simplilearn.model.Subjects;
import com.simplilearn.util.HibernateSessionUtil;

@WebServlet("/add-subject")
public class AddSubjects extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//request.getRequestDispatcher("index.jsp").include(request, response);
		request.getRequestDispatcher("add-subject.html").include(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//add top nav 
		//request.getRequestDispatcher("index.jsp").include(request, response);

		// fetch data from form
		String SubjectName = request.getParameter("subname");
		String SubjectCode = request.getParameter("subcode");
		//String ClassSection = request.getParameter("section");
		//;

		try {
			// 1. build hibernate session factory
			SessionFactory factory = HibernateSessionUtil.buildSessionFactory();

			// 2. create session object
			Session session = factory.openSession();

			// 3. create a product object
			Subjects subj = new Subjects(SubjectName,SubjectCode);

			// 4. begin transaction
			Transaction tx = session.beginTransaction();

			// 5. save product
			session.save(subj);

			// 6. commit transaction
			tx.commit();

			if(session != null ) {
				out.print("<h3 style='color:green'> Subject is Added sucessfully ! </h3>");
			}

			// 3. close session
			session.close();
		} catch (Exception e) {
			out.print("<h3 style='color:red'> Hibernate session is failed ! </h3>");
		}
	}
}