package jpa.entitymodels;
import java.util.*;
import jakarta.persistence.*;

@Entity
@Table
public class Student {
	
	@Id
	@Column(name ="email",nullable=false,length=50)
	private String sEmail;
	@Column(name ="name",nullable=false,length=50)
	private String sName;
	@Column(name ="password",nullable=false,length=50)
	private String sPass;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Student_Course",
		joinColumns ={ @JoinColumn(name ="stud_email")},
		inverseJoinColumns = {@JoinColumn(name = "course_id")})
	private List<Course> sCourses = new ArrayList<Course>();
	
	public Student() {
		
	}
	
	public Student(String sEmail, String sName, String sPass) {
		super();
		this.sEmail = sEmail;
		this.sName = sName;
		this.sPass = sPass;
	}

	public Student(String sEmail, String sName, String sPass, List<Course> sCourses) {
		super();
		this.sEmail = sEmail;
		this.sName = sName;
		this.sPass = sPass;
		this.sCourses = sCourses;
	}

	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsPass() {
		return sPass;
	}
	public void setsPass(String sPass) {
		this.sPass = sPass;
	}
	public List<Course> getsCourses() {
		return sCourses;
	}
	public void setsCourses(List<Course> sCourses) {
		this.sCourses = sCourses;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sEmail == null) ? 0 : sEmail.hashCode());
		result = prime * result + ((sName == null) ? 0 : sName.hashCode());
		result = prime * result + ((sPass == null) ? 0 : sPass.hashCode());
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
		Student other = (Student) obj;
		if (sEmail == null) {
			if (other.sEmail != null)
				return false;
		} else if (!sEmail.equals(other.sEmail))
			return false;
		if (sName == null) {
			if (other.sName != null)
				return false;
		} else if (!sName.equals(other.sName))
			return false;
		if (sPass == null) {
			if (other.sPass != null)
				return false;
		} else if (!sPass.equals(other.sPass))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student Email=" + sEmail + ", Name=" + sName + ", Password=" + sPass  ;
	}
	
	
	
	

}
