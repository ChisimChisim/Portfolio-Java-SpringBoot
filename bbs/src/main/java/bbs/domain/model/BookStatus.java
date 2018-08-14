package bbs.domain.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class BookStatus implements Serializable{
	@Id
	private Long id;    //(=Book.bookId)
	
	//Borrowing status 
	private String status;   //(1:available, 0:borrowing)
	
	@OneToOne(mappedBy="bookStatus")
	@MapsId("id")
	@JoinColumn(name="book_id")
	private Book book;
	

	//Constructor
	public BookStatus() {
	}

    //Getter and Setter
	public BookStatus(Long id, String status, Book book) {
		this.id = id;
		this.status = status;
		this.book = book;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}

	
}
