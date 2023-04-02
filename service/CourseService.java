package jpa.service;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Query;
import jpa.dao.CourseDAO;
import jpa.entitymodels.*;


public class CourseService implements CourseDAO {
	final SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Course.class)
			.buildSessionFactory();
	final Session session = factory.openSession();

	public List<Course> getAllCourses() {
		Query query = session.createQuery("from Course",Course.class);
		List<Course> list = query.getResultList();
		return list;
	}
	public List<Course> getCourseById(int id) {
		Query query = session.createQuery("from Course c where c.cId = :id",Course.class);
		query.setParameter("id", id);
		List<Course> list= query.getResultList();
		return list;
	}

}
