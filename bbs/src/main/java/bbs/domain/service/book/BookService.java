package bbs.domain.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import bbs.domain.repository.book.BookRepository;

@Service
@Transactional
public class BookService {
	@Autowired
	BookRepository bookRepository;
	
  
}
