package bbs.app.review;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bbs.domain.model.AppBorrowing;
import bbs.domain.model.Book;
import bbs.domain.model.Rating;
import bbs.domain.model.Review;
import bbs.domain.model.ReviewForm;
import bbs.domain.model.ReviewId;
import bbs.domain.model.RoleName;
import bbs.domain.model.User;
import bbs.domain.service.book.BookService;
import bbs.domain.service.book.RatingService;
import bbs.domain.service.borrowing.AppBorrowingService;
import bbs.domain.service.review.ReviewService;
import bbs.domain.service.user.BorrowingUserDetails;

@Controller
@RequestMapping("reviews")
public class ReviewController {
	@Autowired
	ReviewService reviewService;
	@Autowired
	RatingService ratingService;
	@Autowired 
	BookService bookService;
	
	@ModelAttribute
	ReviewForm setUpForm() {
		ReviewForm form = new ReviewForm();
		return form;
	}

	@GetMapping(path = "{bookId}")
	String bookDescription(@PathVariable("bookId") Long bookId, Model model,
			@AuthenticationPrincipal BorrowingUserDetails userDetails,
			ReviewForm form) {
		
		Rating book = ratingService.findOneByBookId(bookId);
		List<Review> reviews = reviewService.findByBookId(bookId);
		Review review = reviewService.findReview(bookId, userDetails.getUsername());
		
		List<Integer> ratingList = new ArrayList<Integer>();
		ratingList.add(1);
		ratingList.add(2);
		ratingList.add(3);
		ratingList.add(4);
		ratingList.add(5);
		
		if(review!=null) {
		    model.addAttribute("reviewExist", "1");
		    BeanUtils.copyProperties(review, form);
		}else {
			model.addAttribute("reviewExist", "0");
		}
		model.addAttribute("myReview", review);
		model.addAttribute("reviews", reviews);
		model.addAttribute("bookInfo", book);
		model.addAttribute("checkOutDate", LocalDate.now());
		model.addAttribute("dueDate", LocalDate.now().plusDays(14));
		model.addAttribute("ratingList", ratingList);
		
		
	    return  "review/bookDescription";
		
	}
	
	@PostMapping(path = "{bookId}", params="delete")
	String deleteReview(@RequestParam("userId") String userId, 
			@PathVariable("bookId") Long bookId, Model model) {
		
		//delete review
		ReviewId reviewId = new ReviewId(bookId, userId);
		reviewService.deleteReview(reviewId);
		
        List<Review> reviews = reviewService.findByBookId(bookId);
        //get average rate
        Review aveReview= new Review();
        Double aveRate = aveReview.calAverage(reviews);
        //set rating
        Rating rating  = new Rating();
		rating.setId(bookId);
		rating.setAveRate(aveRate);
		ratingService.update(rating);
		
		return "redirect:/reviews/{bookId}";
	}
	
	@PostMapping(path = "{bookId}", params="create")
	String createReview(@RequestParam("userId") String userId, 
			@PathVariable("bookId") Long bookId, 
			@AuthenticationPrincipal BorrowingUserDetails userDetails,
			ReviewForm form, Model model) {
		
		
		Book book = bookService.findOneByBookId(bookId);
		User user = userDetails.getUser();
		
		//add or edit review
		ReviewId reviewId = new ReviewId(bookId, userId);
		Review review = new Review();
		review.setReviewId(reviewId);
		review.setComment(form.getComment());
		review.setRate(form.getRate());
		review.setBook(book);
		review.setUser(user);
		reviewService.createReview(review);
		
		List<Review> reviews = reviewService.findByBookId(bookId);
		
        //get average rate
        Review aveReview= new Review();
        Double aveRate = aveReview.calAverage(reviews);
        //set rating
		Rating rating  = new Rating();
		rating.setId(bookId);
		rating.setAveRate(aveRate);
		rating.setBook(book);
		ratingService.update(rating);
		
		return "redirect:/reviews/{bookId}";
	}
	
}
