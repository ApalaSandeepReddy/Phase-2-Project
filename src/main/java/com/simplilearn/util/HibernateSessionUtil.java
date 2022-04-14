package com.simplilearn.util;
import org.hibernate.SessionFactory;




import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.simplilearn.model.Classes;
import com.simplilearn.model.Student;
import com.simplilearn.model.Subjects;
import com.simplilearn.model.Teacher;

public class HibernateSessionUtil {

	private static SessionFactory factory;

	public static SessionFactory buildSessionFactory() {		
		// load configuration
		factory = new Configuration().configure("hibernate.cfg.xml")
				//add mapping
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(Classes.class)
			.addAnnotatedClass(Subjects.class)

				.buildSessionFactory();

		return factory;
	}
} 