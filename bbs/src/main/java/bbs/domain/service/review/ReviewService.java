package bbs.domain.service.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bbs.domain.model.Rating;
import bbs.domain.model.Review;
import bbs.domain.repository.review.ReviewRepository;

@Service
@Transactional
public class ReviewService {
	@Autowired
	ReviewRepository reviewRepository;
	
	public List<Review> findByBookId(Long bookId) {
	  	   List<Review> reviews = reviewRepository.findByBookIdOrderByRegistrationDate(bookId);
	  	   return reviews;
	   }
	
	
}
