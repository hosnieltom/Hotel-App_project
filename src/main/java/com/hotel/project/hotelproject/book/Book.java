package com.hotel.project.hotelproject.book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Book {
	
	@Id
	@SequenceGenerator(
			name = "book_sequence",
			sequenceName = "book_sequence",
			allocationSize = 1)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "book_sequence" )
	
	private long id;
	private long isbnNumber;
	private int pageNumber;
	private String author;
	private String title;
	private String location;
	
	public Book() {
		
	}

	public Book(long id, long isbnNumber, int pageNumber, String author, String title, String location) {
		super();
		this.id = id;
		this.isbnNumber = isbnNumber;
		this.pageNumber = pageNumber;
		this.author = author;
		this.title = title;
		this.location = location;
	}

	public Book(long isbnNumber, int pageNumber, String author,String title, String location) {
		super();
		this.isbnNumber = isbnNumber;
		this.pageNumber = pageNumber;
		this.author = author;
		this.title = title;
		this.location = location;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(long isbnNumber) {
		this.isbnNumber = isbnNumber;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", isbnNumber=" + isbnNumber + ", pageNumber=" + pageNumber + ", author=" + author
				+ ", title=" + title +", location=" + location + "]";
	}
	

}
