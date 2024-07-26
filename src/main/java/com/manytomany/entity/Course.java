package com.manytomany.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course {
	
	@Id
	private int courseId;
	private String courseName;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "coursesList")
	private List<Student> studentsList = new ArrayList();

	public Course() {
		super();
	}

	public Course(int courseId, String courseName) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
	}

	public Course(int courseId, String courseName, List<Student> studentsList) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.studentsList = studentsList;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<Student> getStudentsList() {
		return studentsList;
	}

	public void setStudentsList(List<Student> studentsList) {
		this.studentsList = studentsList;
	}

	@Override
	public String toString() {
	    return "Course [courseId=" + courseId + ", courseName=" + courseName + "]";
	}
	
	
	
}
