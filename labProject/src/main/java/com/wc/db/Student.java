package com.wc.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "student")
public class Student {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "student_no")
	private int studentNo;
	
	@Column(name = "student_name")
	private String name;
	
	@Column(name = "student_email")
	private String studentEmail;
	
	@Column(name = "student_password")
	private String studentPassword;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentNo=" + studentNo + ", name="
				+ name + ", studentEmail=" + studentEmail
				+ ", studentPassword=" + studentPassword + "]";
	}
	
	
}
