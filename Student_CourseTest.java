package com.perscholas.SMS;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;
import jakarta.persistence.*;
import jpa.entitymodels.*;
import jpa.service.*;

public class Student_CourseTest {
	Student hazel;
	Student alexandra;
	Course phy;
	List<Student> list1 = new ArrayList<Student>();
	List<Course> list2 = new ArrayList<Course>();
	StudentService stS;
	
	@Before
	public void setUp() throws Exception {
		hazel = new Student("hluckham0@google.ru","Hazel Luckham","X1uZcoIh0dj");				
		list1.add(hazel);
		alexandra = new Student("aiannitti7@is.gd","Alexandra Iannitti","TWP4hf5j");
		phy = new Course(5,"Physics","Dani Swallow");
		list2.add(phy);
		stS = new StudentService();
		
	}

	@Test
	public  void getStudentByEmailtest() {
		assertEquals(list1,stS.getStudentByEmail(hazel.getsEmail()));
	}
	
	//At the moment of testing the test was true
	@Test
	public void getStudentCoursesTest() {
		assertEquals(list2, stS.getStudentCourses(alexandra.getsEmail()));
	}

}
