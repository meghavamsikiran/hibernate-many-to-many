package com.manytomany.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Book {
	
	@Id
	private int bookId;
	private String bookName;
	
	//@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER.EAGER, mappedBy = "booksList")
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER.EAGER)
	@JoinTable(
	        name = "book_author",
	        joinColumns = @JoinColumn(name = "bookId"),
	        inverseJoinColumns = @JoinColumn(name = "authorId"))
	private List<Author> authorList = new ArrayList<>();
	public Book() {
		super();
	}
	public Book(int bookId, String bookName) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
	}
	public Book(int bookId, String bookName, List<Author> authorList) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorList = authorList;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public List<Author> getAuthorList() {
		return authorList;
	}
	public void setAuthorList(List<Author> authorList) {
		this.authorList = authorList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorList == null) ? 0 : authorList.hashCode());
		result = prime * result + bookId;
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
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
		Book other = (Book) obj;
		if (authorList == null) {
			if (other.authorList != null)
				return false;
		} else if (!authorList.equals(other.authorList))
			return false;
		if (bookId != other.bookId)
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", authorList=" + authorList + "]";
	}
	
	
}
