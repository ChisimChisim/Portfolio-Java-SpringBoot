package bbs.domain.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Book implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long bookId;
	
	private String title;
	
	@Lob
	private String text;
	
	@Enumerated(EnumType.STRING)
	private Genru genru;
	
	private String author;
	
	private String releasedDate;
	
	@OneToOne(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="status_id")
	private BookStatus bookStatus;
	

    // Constructor	
	public Book() {}


	public Book(Long bookId, String title, String text, Genru genru, String author, String releasedDate,
			BookStatus bookStatus) {
		this.bookId = bookId;
		this.title = title;
		this.text = text;
		this.genru = genru;
		this.author = author;
		this.releasedDate = releasedDate;
		this.bookStatus = bookStatus;
	}

    //Getter and Setter
	public Long getBookId() {
		return bookId;
	}


	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public Genru getGenru() {
		return genru;
	}


	public void setGenru(Genru genru) {
		this.genru = genru;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getReleasedDate() {
		return releasedDate;
	}


	public void setReleasedDate(String releasedDate) {
		this.releasedDate = releasedDate;
	}


	public BookStatus getBookStatus() {
		return bookStatus;
	}


	public void setBookStatus(BookStatus bookStatus) {
		this.bookStatus = bookStatus;
	}

	
	
}
