package bbs.domain.repository.book;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bbs.domain.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	@Query("SELECT x FROM Book x WHERE x.bookId = :bookId")
	Book findOneBybookId(@Param("bookId") Long bookId);
}
