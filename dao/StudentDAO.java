package jpa.dao;
import java.util.*;
import jpa.entitymodels.*;

public interface StudentDAO {
	public List<Student> getAllStudents();

	public List<Student> getStudentByEmail(String email);

	public boolean validateStudent(String email, String password);

	public void registerStudentToCourse(String email, Course c);

	public List getStudentCourses(String email);

}
