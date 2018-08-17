package bbs.domain.service.borrowing;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bbs.domain.model.AppBorrowing;
import bbs.domain.model.Book;
import bbs.domain.model.BookStatus;
import bbs.domain.model.RoleName;
import bbs.domain.model.User;
import bbs.domain.repository.book.BookRepository;
import bbs.domain.repository.book.BookStatusRepository;
import bbs.domain.repository.borrowing.AppBorrowingRepository;

@Service
@Transactional
public class AppBorrowingService {
	@Autowired
	AppBorrowingRepository appBorrowingRepository;
	@Autowired
	BookStatusRepository bookStatusRepository;
	@Autowired
	BookRepository bookRepository;
	
	public List<AppBorrowing> getBorrowingList(){
	  List<AppBorrowing> appBorrowing = appBorrowingRepository.findByStatus0AndUser(dummyUser().getUserId());
	  return appBorrowing;
	  
	}
	
	public List<AppBorrowing> historyList(){
		  List<AppBorrowing> appBorrowing = appBorrowingRepository.findByStatus1AndUser(dummyUser().getUserId());
		  return appBorrowing;
		  
		}
	
	public AppBorrowing checkOut(Long bookId) {
	 //LockModeType.PESSIMISTIC_WRITE   
        AppBorrowing appBorrowing = appBorrowingRepository.findOneForUpdateBybookIdAndStatus(bookId);
        
	 // if the book with status '0' ('0'=Unavairable) is already exist in AppBorrowing, error message is displayed. 
	    if(appBorrowing != null) {
		  throw new UnavairableBorrowingException("The book is not avairable.");
	  }
	    
	    BookStatus bookStatus = new BookStatus();
	    bookStatus.setId(bookId);
	    bookStatus.setStatus("0");
	    //Change book status
	    bookStatusRepository.save(bookStatus); 
	    
	    Book book = bookRepository.findOneBybookId(bookId);
	    
	    AppBorrowing appB = new AppBorrowing();
		appB.setBorrowingDate(LocalDate.now());
		appB.setDueDate(LocalDate.now().plusDays(14));
	    appB.setReturnDate(null);
		appB.setStatus("0");
		appB.setBook(book);
		appB.setUser(dummyUser());
		//Registor the check-out info
		appBorrowingRepository.save(appB); 
		
		return appB;
	    
	}
	
	public void returnBook(Long bookId, Long borrowingId) {
		
       
	    
	    AppBorrowing appB = appBorrowingRepository.findOneById(borrowingId);
	    appB.setReturnDate(LocalDate.now());
		appB.setStatus("1");
		//Return the book
		appBorrowingRepository.save(appB);
		
		BookStatus bookStatus = new BookStatus();
	    bookStatus.setId(bookId);
	    bookStatus.setStatus("1");
	    //Change book status
	    bookStatusRepository.save(bookStatus); 
	   
		
	}
	
	private User dummyUser() {
		User user = new User();
		user.setUserId("ychieko");
		user.setFirstName("Chieko");
		user.setLastName("Yamamoto");
		user.setRoleName(RoleName.ADMIN);
		return user;
	}
	    
	    
	  
	  
	}
	
	
