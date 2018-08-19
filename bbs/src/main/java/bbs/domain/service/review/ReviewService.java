package bbs.domain.service.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import bbs.domain.model.Review;
import bbs.domain.model.ReviewId;
import bbs.domain.model.User;
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
	
	public Review findReview(Long bookId, String userId) {
	       Review review= reviewRepository.findOneByBookIdAndUserId(bookId, userId);
	       return review;
}
	public void deleteReview(ReviewId reviewId) {
		reviewRepository.deleteById(reviewId);		
	}
	
	public Review createReview(Review review){
        reviewRepository.save(review);
       
		return review;
	}
	
    
}
