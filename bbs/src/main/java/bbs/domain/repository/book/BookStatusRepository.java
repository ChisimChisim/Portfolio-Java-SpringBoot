package bbs.domain.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;

import bbs.domain.model.BookStatus;

public interface BookStatusRepository extends JpaRepository<BookStatus, Long>{
	

}
