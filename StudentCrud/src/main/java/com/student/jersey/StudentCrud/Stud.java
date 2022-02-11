package com.student.jersey.StudentCrud;

import java.util.Date;

public class Stud {
	
	private int Student_No;
	private String Student_Name;
	private Date Student_DOB;
	private Date Student_DOJ;
	public int getStudent_No() {
		return Student_No;
	}
	public void setStudent_No(int student_No) {
		Student_No = student_No;
	}
	public String getStudent_Name() {
		return Student_Name;
	}
	public void setStudent_Name(String student_Name) {
		Student_Name = student_Name;
	}
	public Date getStudent_DOB() {
		return Student_DOB;
	}
	public void setStudent_DOB(Date student_DOB) {
		Student_DOB = student_DOB;
	}
	public Date getStudent_DOJ() {
		return Student_DOJ;
	}
	public void setStudent_DOJ(Date student_DOJ) {
		Student_DOJ = student_DOJ;
	}
	@Override
	public String toString() {
		return "Stud [Student_No=" + Student_No + ", Student_Name=" + Student_Name + ", Student_DOB=" + Student_DOB
				+ ", Student_DOJ=" + Student_DOJ + "]";
	}
	

}
