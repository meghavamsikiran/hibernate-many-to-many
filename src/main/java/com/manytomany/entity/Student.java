package com.manytomany.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {
	
	@Id
	private int studentId;
	private String studentName;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "student_course",
	joinColumns = @JoinColumn(name = "studentId"),
	inverseJoinColumns = @JoinColumn(name = "courseId"))
	private List<Course> coursesList = new ArrayList<>();

	public Student() {
		super();
	}

	public Student(int studentId, String studentName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
	}

	public Student(int studentId, String studentName, List<Course> coursesList) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.coursesList = coursesList;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public List<Course> getCoursesList() {
		return coursesList;
	}

	public void setCoursesList(List<Course> coursesList) {
		this.coursesList = coursesList;
	}

	@Override
	public String toString() {
	    return "Student [studentId=" + studentId + ", studentName=" + studentName + "]";
	}
	
	
}
