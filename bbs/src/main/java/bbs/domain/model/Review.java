package bbs.domain.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Review implements Serializable{
	@EmbeddedId
	private ReviewId reviewId;
	
	private Integer rate;
	
	@Lob
	private String comment;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="book_id", insertable=false, updatable=false)
	@MapsId("bookId")
	private Book book;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id", insertable=false, updatable=false)
	@MapsId("userId")
	private User user;

	
	// Constructor	
	public Review() {}


	public Review(ReviewId reviewId, Integer rate, String comment, Book book, User user) {
		this.reviewId = reviewId;
		this.rate = rate;
		this.comment = comment;
		this.book = book;
		this.user = user;
	}

    //Getter and Setter
	public ReviewId getReviewId() {
		return reviewId;
	}


	public void setReviewId(ReviewId reviewId) {
		this.reviewId = reviewId;
	}


	public Integer getRate() {
		return rate;
	}


	public void setRate(Integer rate) {
		this.rate = rate;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
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
