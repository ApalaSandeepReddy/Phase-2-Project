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

import com.simplilearn.model.Teacher;
import com.simplilearn.util.HibernateSessionUtil;

@WebServlet("/add-teacher")
public class AddTeacher extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//request.getRequestDispatcher("index.jsp").include(request, response);
		request.getRequestDispatcher("add-teacher.html").include(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//add top nav 
		//request.getRequestDispatcher("index.jsp").include(request, response);

		// fetch data from form
		String TeacherName = request.getParameter("name");
		String techerEmail=request.getParameter("email");
		String teacherAddress = request.getParameter("address");
		String teachersubject=request.getParameter("subject");

		try {
			// 1. build hibernate session factory
			SessionFactory factory = HibernateSessionUtil.buildSessionFactory();

			// 2. create session object
			Session session = factory.openSession();

			// 3. create a product object
			Teacher product = new Teacher(TeacherName, techerEmail, teacherAddress,teachersubject);

			// 4. begin transaction
			Transaction tx = session.beginTransaction();

			// 5. save product
			session.save(product);

			// 6. commit transaction
			tx.commit();

			if(session != null ) {
				out.print("<h3 style='color:green'> Teacher is created sucessfully ! </h3>");
			}

			// 3. close session
			session.close();
		} catch (Exception e) {
			out.print("<h3 style='color:red'> Hibernate session is failed ! </h3>");
		}
	}
}
