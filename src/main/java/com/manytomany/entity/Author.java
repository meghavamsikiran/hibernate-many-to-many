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
public class Author {
	
	@Id
	private int authorId;
	private String authorName;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "authorList")
//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// mappedBy = "the name of the List<Author> collection declared in Book.java goes here"
	
//	@JoinTable(
//	        name = "book_author",
//	        joinColumns = @JoinColumn(name = "bookId"),
//	        inverseJoinColumns = @JoinColumn(name = "authorId"))
	private List<Book> booksList=new ArrayList<>();

	public Author() {
		super();
	}

	public Author(int authorId, String authorName) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
	}

	public Author(int authorId, String authorName, List<Book> booksList) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.booksList = booksList;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public List<Book> getBooksList() {
		return booksList;
	}

	public void setBooksList(List<Book> booksList) {
		this.booksList = booksList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + authorId;
		result = prime * result + ((authorName == null) ? 0 : authorName.hashCode());
		result = prime * result + ((booksList == null) ? 0 : booksList.hashCode());
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
		Author other = (Author) obj;
		if (authorId != other.authorId)
			return false;
		if (authorName == null) {
			if (other.authorName != null)
				return false;
		} else if (!authorName.equals(other.authorName))
			return false;
		if (booksList == null) {
			if (other.booksList != null)
				return false;
		} else if (!booksList.equals(other.booksList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + ", booksList=" + booksList + "]";
	}
	
	
	
}
