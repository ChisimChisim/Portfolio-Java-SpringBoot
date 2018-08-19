package bbs.domain.service.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bbs.domain.model.Book;
import bbs.domain.model.Rating;
import bbs.domain.repository.book.RatingRepository;

@Service
@Transactional
public class RatingService {
	@Autowired
	RatingRepository ratingRepository;
	
	public List<Rating> findAll() {
	  	   List<Rating> ratings = ratingRepository.findAllOrderBYBookIdAsc(); 
	  	   return ratings;
	   }
	   
	   public Rating findOneByBookId(Long bookId){
		   Rating rating = ratingRepository.findOneBybookId(bookId);
		   return rating;
	   }
	   
       public Rating update(Rating rating) {
    	     ratingRepository.save(rating);
    	   return rating;
       }
}
