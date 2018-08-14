package bbs.domain.repository.review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bbs.domain.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{
	@Query("SELECT x FROM Review x INNER JOIN FETCH x.book r INNER JOIN FETCH x.user u WHERE x.reviewId.bookId = :bookId")
	List<Review> findByBookIdOrderByRegistrationDate(@Param("bookId") Long bookId);
	

}
