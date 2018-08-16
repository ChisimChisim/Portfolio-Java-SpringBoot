package bbs.app.borrowing;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bbs.domain.model.AppBorrowing;
import bbs.domain.model.Book;
import bbs.domain.service.book.BookService;
import bbs.domain.service.borrowing.AppBorrowingService;
import bbs.domain.service.borrowing.UnavairableBorrowingException;


@Controller
@RequestMapping("borrowing")
public class AppBorrowingConstoller {
	@Autowired
	AppBorrowingService appBorrowingService;
	@Autowired
	BookService bookService;
	
	@PostMapping(path="{bookId}/checkout")
	String checkOut(@PathVariable("bookId") Long bookId, 
			 Model model) {
		
		AppBorrowing checkOutInfo;
		
		try {
			
		checkOutInfo = appBorrowingService.checkOut(bookId);
		
		}catch(UnavairableBorrowingException e){
			model.addAttribute("error", e.getMessage());
			return "borrowing/checkOutComplete";	
		}

		model.addAttribute("checkout", checkOutInfo);
		return "borrowing/checkOutComplete";
		
	}
}
