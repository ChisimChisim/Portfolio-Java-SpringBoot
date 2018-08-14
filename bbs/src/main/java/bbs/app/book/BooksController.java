package bbs.app.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import bbs.domain.model.Book;
import bbs.domain.model.Rating;
import bbs.domain.model.Review;
import bbs.domain.service.book.BookService;
import bbs.domain.service.book.RatingService;
import bbs.domain.service.review.ReviewService;

@Controller
@RequestMapping("books")
public class BooksController {
	@Autowired
	BookService bookService;
	@Autowired
	RatingService ratingService;
	@Autowired
	ReviewService reviewService;
	
	@GetMapping
	String listBooks(Model model) {
		List<Rating> book = ratingService.findAll();
		model.addAttribute("books", book);
		
		return "book/listBooks";
		
	}
	
	@GetMapping(path = "{bookId}")
	String bookDescription(@PathVariable("bookId") Long bookId, Model model) {
		Rating book = ratingService.findOneByBookId(bookId);
		List<Review> reviews = reviewService.findByBookId(bookId);
		
		model.addAttribute("bookInfo", book);
		model.addAttribute("reviews", reviews);
	    return  "book/bookDescription";
		
	}
	
	

}
