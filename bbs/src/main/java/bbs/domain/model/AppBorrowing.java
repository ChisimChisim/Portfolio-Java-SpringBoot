package bbs.domain.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class AppBorrowing implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long borrowingId;
	
	private LocalDate borrowingDate;
	
	private LocalDate dueDate;
	
	private LocalDate returnDate;
	
	private String status;     //(1:available, 0:borrowing)
	
	@ManyToOne
	@JoinColumn(name="book_id")
	private Book book;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	

	// Constructor	
	public AppBorrowing() {}

    public AppBorrowing(Long borrowingId, LocalDate borrowingDate, LocalDate dueDate, LocalDate returnDate,
			String status, Book book, User user) {
		this.borrowingId = borrowingId;
		this.borrowingDate = borrowingDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.status = status;
		this.book = book;
		this.user = user;
	}


	//Getter and Setter
	public Long getBorrowingId() {
		return borrowingId;
	}


	public void setBorrowingId(Long borrowingId) {
		this.borrowingId = borrowingId;
	}


	public LocalDate getBorrowingDate() {
		return borrowingDate;
	}


	public void setBorrowingDate(LocalDate borrowingDate) {
		this.borrowingDate = borrowingDate;
	}


	public LocalDate getDueDate() {
		return dueDate;
	}


	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}


	public LocalDate getReturnDate() {
		return returnDate;
	}


	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
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


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
}
