package bbs.domain.model;

import javax.validation.constraints.Size;

public class ReviewForm {
	
	private Integer rate;
	
	private String comment;


	public ReviewForm() {
	}



	public ReviewForm(Integer rate, String comment) {
		this.rate = rate;
		this.comment = comment;
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

	
	

}
