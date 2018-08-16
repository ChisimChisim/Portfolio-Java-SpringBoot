package bbs.domain.service.book;

import org.springframework.beans.factory.annotation.Autowired;

import bbs.domain.model.BookStatus;
import bbs.domain.repository.book.BookStatusRepository;

public class BookStatusService {
	@Autowired
	BookStatusRepository bookStatusRepository;
	
	
}
