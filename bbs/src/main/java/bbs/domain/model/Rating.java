package bbs.domain.model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

@Entity
public class Rating implements Serializable{
	@Id
	private Long id;   //(= Book.bookId)
	
	private Float aveRate;
	
	private Float totalRate;
	
	private Integer numRate;
	
	@OneToOne(fetch=FetchType.LAZY)
	@MapsId("id")
	@JoinColumn(name="book_id")
	private Book book;
	
	
	//Constructor
	public Rating() {}	

	public Rating(Long id, Float aveRate, Float totalRate, Integer numRate, Book book) {
		this.id = id;
		this.aveRate = aveRate;
		this.totalRate = totalRate;
		this.numRate = numRate;
		this.book = book;
	}



	//Getter and Setter
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Float getAveRate() {
		return aveRate;
	}


	public void setAveRate(Float aveRate) {
		this.aveRate = aveRate;
	}


	public Float getTotalRate() {
		return totalRate;
	}


	public void setTotalRate(Float totalRate) {
		this.totalRate = totalRate;
	}


	public Integer getNumRate() {
		return numRate;
	}


	public void setNumRate(Integer numRate) {
		this.numRate = numRate;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}

	
}
