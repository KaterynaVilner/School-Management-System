package jpa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Query;
import jpa.dao.ConnectionDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentCourseService {
	
	
	public List<Course> getAllStudentCourses(String email) {
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
