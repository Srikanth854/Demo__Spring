package com.zemoso.springboot.thymeleafdemo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="deptid")
	public int deptId;
	
	@NotNull(message="is required")
	@Column(name="deptname")
	private String deptName;
	
	
	@NotNull(message="is required")
	@Column(name="deptcode") String deptCode;
	
	@NotNull(message="is required")
	@Column(name="deptmail")
	private String deptMail;
	
	
	   @OneToMany(fetch=FetchType.LAZY,
	            mappedBy = "department",
	            cascade = {CascadeType.ALL})
	    private List<Student> theStudents;

	   
	
	public List<Student> getTheStudents() {
		return theStudents;
	}



	public void setTheStudents(List<Student> theStudents) {
		this.theStudents = theStudents;
	}
	
	
	public void add(Student theStudent)
	    {
	        if(theStudents==null)
	        {
	        	theStudents=new ArrayList<>();
	        }
	        //theInterns.add(theIntern);
	        theStudent.setDepartment(this);
	    }


	public Department() {
		
	}
	
	

	public Department(int deptId, String deptName, String deptCode,  String deptMail) {
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptCode = deptCode;
		this.deptMail = deptMail;
	}



	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptMail() {
		return deptMail;
	}

	public void setDeptMail(String deptMail) {
		this.deptMail = deptMail;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", deptCode=" + deptCode + ", deptMail="
				+ deptMail + "]";
	}
	
	
	
	
}
