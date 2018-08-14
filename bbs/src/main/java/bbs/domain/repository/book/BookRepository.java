package bbs.domain.repository.book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bbs.domain.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{


}
