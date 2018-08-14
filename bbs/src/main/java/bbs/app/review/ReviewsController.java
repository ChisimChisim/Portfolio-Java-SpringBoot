package bbs.app.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import bbs.domain.model.ReviewId;
import bbs.domain.service.review.ReviewService;

@Controller
@RequestMapping("reviews/{bookId}/{userId}")
public class ReviewsController {
	@Autowired
	ReviewService reviewService;
		
	

}
