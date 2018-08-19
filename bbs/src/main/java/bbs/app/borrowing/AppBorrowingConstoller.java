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
	
	@GetMapping(path="{bookId}/checkout", params="confirm")
	String confirmCheckOut(@PathVariable("bookId") Long bookId,
			@RequestParam("title") String title, 
			 Model model ) {
	
		model.addAttribute("borrowingId", "-");
		model.addAttribute("bookId", bookId);
		model.addAttribute("title", title);
		model.addAttribute("checkOutDate", LocalDate.now());
		model.addAttribute("dueDate", LocalDate.now().plusDays(14));
		
		return "borrowing/checkOutConfirm";
		
	}
	
	@PostMapping(path="{bookId}/checkout")
	String checkOut(@PathVariable("bookId") Long bookId, 
			 Model model) {
		
		AppBorrowing checkOutInfo;
		
		try {
			
		checkOutInfo = appBorrowingService.checkOut(bookId);
		
		}catch(UnavairableBorrowingException e){
			model.addAttribute("error", e.getMessage());
			return "redirect:borrowing/checkOutConfirm";	
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
		return "redirect:/borrowing/list";
		
	}
	
	@GetMapping(path="history")
	String hiroty(Model model) {
		
		List<AppBorrowing> history = appBorrowingService.historyList();
		model.addAttribute("histories", history);
		
		return  "borrowing/history";
	}
	
}
