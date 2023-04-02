package jpa.entitymodels;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table
public class Course {
	
	@Id
	@Column(name ="id",nullable=false)
	private int cId;
	@Column(name ="name",nullable=false,length=50)
	private String cName;
	@Column(name ="Instructor",nullable=false,length=50)
	private String cInstructorName;
	@ManyToMany(mappedBy ="sCourses", cascade = {CascadeType.ALL})
	private List<Student> students = new ArrayList<Student>();
	
	public Course() {
		
	}
	
	public Course(int cId, String cName, String cInstructorName) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cInstructorName = cInstructorName;
	}

	public Course(int cId, String cName, String cInstructorName, List<Student> students) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cInstructorName = cInstructorName;
		this.students = students;
	}

	public List<Student> getStudents(){
		return students;
	}
	public void setStudents(List<Student> stu){
		this.students=stu;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcInstructorName() {
		return cInstructorName;
	}
	public void setcInstructorName(String cInstructorName) {
		this.cInstructorName = cInstructorName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cId;
		result = prime * result + ((cInstructorName == null) ? 0 : cInstructorName.hashCode());
		result = prime * result + ((cName == null) ? 0 : cName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (cId != other.cId)
			return false;
		if (cInstructorName == null) {
			if (other.cInstructorName != null)
				return false;
		} else if (!cInstructorName.equals(other.cInstructorName))
			return false;
		if (cName == null) {
			if (other.cName != null)
				return false;
		} else if (!cName.equals(other.cName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Course " + cId + ", " + cName + ", " + cInstructorName ;
	}
	
	

}
