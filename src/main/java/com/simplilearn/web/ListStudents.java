package com.simplilearn.web;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.simplilearn.model.Student;

import com.simplilearn.util.HibernateSessionUtil;

@WebServlet("/list-students")
public class ListStudents extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//request.getRequestDispatcher("index.jsp").include(request, response);

		try {
			// 1. build hibernate session factory
			SessionFactory factory = HibernateSessionUtil.buildSessionFactory();

			// 2. create session object
			Session session = factory.openSession();

			// 3. read Customers
			List<Student> students = session.createQuery("from Student").list();

			//show data as table.
			out.print("<h1 style='align-center' color='green'> Students List :- </h1>");

			out.print("<style> table,td,th {"
					+ "border:2px solid red;"
					+ "padding: 10px; "
					+ "}</style>");
			out.print("<table >");
			out.print("<tr>");
				out.print("<th> Student Id</th>");
				out.print("<th> Student Name</th>");
				out.print("<th> Student Rollno</th>");
				out.print("<th> Student Address</th>");
				out.print("<th> Student Class </th>");
				out.print("<th> Student Gender </th>");
				out.print("<th> Student DateofBirth </th>");
			out.print("</tr>");

			for(Student p : students) {
				out.print("<tr>");
				out.print("<td>"+p.getId()+"</td>");
				out.print("<td>"+p.getName()+"</td>");
				out.print("<td>"+p.getRollno()+"</td>");
				out.print("<td>"+p.getAd()+"</td>");
				out.print("<td>"+p.getCl()+"</td>");
				out.print("<td>"+p.getGender()+"</td>");
				out.print("<td>"+p.getDob()+"</td>");
				out.print("</tr>");
			}
			out.print("</table><br><br>");
			out.print("<h3><a href='add-student'>Back </a></h3>");
			// 3. close session
			session.close();
		} catch (Exception e) {
			out.print("<h3 style='color:red'> Hibernate session is failed ! </h3>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}