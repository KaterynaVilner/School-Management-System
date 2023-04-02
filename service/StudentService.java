package jpa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jpa.dao.ConnectionDAO;
import jakarta.persistence.*;
import jpa.dao.StudentDAO;
import jpa.entitymodels.*;




public class StudentService implements StudentDAO {
	final SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Student.class)
			.buildSessionFactory();
	final Session session = factory.openSession();

	public List<Student> getAllStudents() {
		Query query = session.createQuery("from Student",Student.class);
		List<Student> list = query.getResultList();
		return list;
	}

	public List<Student> getStudentByEmail(String email) {
		Query query = session.createQuery("from Student where sEmail =:email",Student.class);
		query.setParameter("email", email);
		List<Student> stud =query.getResultList();
		return stud;		
		
	}

	public boolean validateStudent(String email, String password) {
		boolean login =false;
		Query query =session.createQuery("Select email, password From Student s where s.sEmail = :email AND sPass = :password",Student.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		if(query.getResultList() !=null) {
			login = true;
		}
		return login;
	}

	public void registerStudentToCourse(String email, Course c) {
	try {
		Connection con = ConnectionDAO.getConnection();
		String sqlQuery ="insert into Student_Course (stud_email, course_id) values (?,?)";
		PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
		prepStmt.setString(1, email);
		prepStmt.setInt(2, c.getcId());
		prepStmt.executeUpdate();
		  
	    System.out.println(getStudentByEmail(email).get(0).getsName() + " is now registered to course "+c.getcName());
	}catch (Exception e) {
		System.out.println("You are already registered to this course");
	}
		
	}

	public List<Course> getStudentCourses(String email) {
		  try {
	           Connection con = ConnectionDAO.getConnection();
	           String sqlQuery = "SELECT * FROM course inner join student_course on id=course_id where stud_email = ?";
	           PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
	           prepStmt.setString(1,  email);
	           ResultSet rs = prepStmt.executeQuery();
	           List courselist = new ArrayList();
	           while(rs.next())
	           {
	        	   Course c = new Course();
	        	   c.setcId(rs.getInt("id"));
	        	   c.setcName(rs.getString("name"));
	        	   c.setcInstructorName(rs.getString("Instructor"));
	        	   courselist.add(c);
	           }
	           return courselist;
		  } catch (SQLException ex) {
	           ex.printStackTrace();
	           System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
	       } catch (ClassNotFoundException e) {
	           e.printStackTrace();
	       }
	       return null;
	           		
	}

}
