package bbs.app.borrowing;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bbs.domain.model.AppBorrowing;
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
	
	@GetMapping(path="list")
	String currentList(Model model) {
		List<AppBorrowing> appBorrowing = appBorrowingService.getBorrowingList();
		model.addAttribute("currentBorrowings", appBorrowing);
		return  "borrowing/currentList";
	}
	
	
	@PostMapping(path="{bookId}/{borrowingId}/return")
	String returnBook(@PathVariable("bookId") Long bookId, @PathVariable("borrowingId") Long borrowingId, Model model) {
		appBorrowingService.returnBook(bookId, borrowingId);
		return "borrowing/history";
		
	}
	
	@GetMapping(path="history")
	String hiroty(Model model) {
		
		List<AppBorrowing> history = appBorrowingService.historyList();
		model.addAttribute("histories", history);
		
		return  "borrowing/history";
	}
	
}
