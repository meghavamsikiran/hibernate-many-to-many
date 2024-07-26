package com.manytomany.io;

import java.util.Scanner;

import com.manytomany.entity.Author;
import com.manytomany.entity.Book;
import com.manytomany.util.EntityUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ManyToMainMain {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. addRecord");
		System.out.println("Select an Option: ");
		int ch = sc.nextInt();
		switch(ch) {
		case 1: addRecord(); break;
		default: System.out.println("Invlaid Input!");
		}
	}
	
	public static void addRecord() {
		Book b1 = new Book(1, "java");
		Book b2 = new Book(2, "python");

		Author a1 = new Author(1, "charlie");
		Author a2 = new Author(2, "chaplin");
		
		b1.getAuthorList().add(a1);
		b1.getAuthorList().add(a2);
		
		b2.getAuthorList().add(a1);
		b2.getAuthorList().add(a2);
		
		
//		a1.getBooksList().add(b1);
//		a1.getBooksList().add(b2);
//		a2.getBooksList().add(b1);
//		a2.getBooksList().add(b2);
		
		EntityManager em = EntityUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(b1);
		em.persist(b2);
		
//		em.persist(a1);
//		em.persist(a2);
		et.commit();
		System.out.println("===> Records Added Successfully!");
		em.close();
	}
}
