package bbs.domain.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bbs.domain.model.Book;
import bbs.domain.model.BookStatus;

public interface BookStatusRepository extends JpaRepository<BookStatus, Long>{
	

}
