package com.manytomany.io;

import java.util.List;
import java.util.Scanner;

import com.manytomany.entity.Course;
import com.manytomany.entity.Student;
import com.manytomany.util.EntityUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CourseToStudentMain {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("1. Add Record");
	    System.out.println("2. Delete CourseById");
	    System.out.println("3. Update CourseById");
	    System.out.println("4. Find CourseById");
	    System.out.println("5. Display Courses");
	    System.out.println("Select an Option: ");
	    int ch = sc.nextInt();
	    switch(ch) {
	        case 1: addRecord(); break;
	        case 2: deleteCourseById(); break;
	        case 3: updateCourseById(); break;
	        case 4: findCourseById(); break;
	        case 5: displayCourses(); break;
	        default: System.out.println("Invalid Input!"); break;
	    }
	}
	
	public static void addRecord() {
		Student s1 = new Student(101, "vamsi");
		Student s2 = new Student(102, "sasi");
		Student s3 = new Student(103, "kousik");
		Student s4 = new Student(104, "vardhan");
		
		Course c1 = new Course(1, "java");
		Course c2 = new Course(2, "python");
		
		s1.getCoursesList().add(c1);
		s1.getCoursesList().add(c2);
		
		s2.getCoursesList().add(c1);
		s2.getCoursesList().add(c2);
		
		s3.getCoursesList().add(c1);
		s3.getCoursesList().add(c2);
		
		s4.getCoursesList().add(c1);
		s4.getCoursesList().add(c2);
		
		EntityManager em = EntityUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		em.persist(s4);
		
		et.commit();
		System.out.println("===> Record Inserted Successfully!");
		em.close();
	}
	public static void deleteCourseById() {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter CourseId to delete: ");
	    int courseId = sc.nextInt();
	    EntityManager em = EntityUtil.getEntityManager();
	    EntityTransaction et = em.getTransaction();
	    Course c = em.find(Course.class, courseId);
	    et.begin();
	    em.remove(c);
	    et.commit();
	    System.out.println("===> Course Deleted Successfully!");
	    em.close();
	}

	public static void updateCourseById() {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter CourseId to update: ");
	    int courseId = sc.nextInt();
	    System.out.println("Enter new CourseName: ");
	    String courseName = sc.next();
	    EntityManager em = EntityUtil.getEntityManager();
	    EntityTransaction et = em.getTransaction();
	    Course c = em.find(Course.class, courseId);
	    c.setCourseName(courseName);
	    et.begin();
	    em.merge(c);
	    et.commit();
	    System.out.println("===> Course Updated Successfully!");
	    em.close();
	}

	public static void findCourseById() {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter CourseId to find: ");
	    int courseId = sc.nextInt();
	    EntityManager em = EntityUtil.getEntityManager();
	    Course c = em.find(Course.class, courseId);
	    System.out.println(c);
	    em.close();
	}

	public static void displayCourses() {
	    EntityManager em = EntityUtil.getEntityManager();
	    List<Course> courses = em.createQuery("SELECT c FROM Course c", Course.class).getResultList();
	    for (Course c : courses) {
	        System.out.println(c);
	    }
	    em.close();
	}
	
}
