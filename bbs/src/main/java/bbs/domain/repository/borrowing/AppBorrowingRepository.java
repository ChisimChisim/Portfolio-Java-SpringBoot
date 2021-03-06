package bbs.domain.repository.borrowing;

import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import bbs.domain.model.AppBorrowing;

public interface AppBorrowingRepository extends JpaRepository<AppBorrowing, Long>{
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("SELECT x FROM AppBorrowing x LEFT JOIN FETCH x.book b LEFT JOIN FETCH b.bookStatus WHERE x.book.bookId = :bookId AND x.status = '0' ")
	AppBorrowing findOneForUpdateBybookIdAndStatus(@Param("bookId") Long bookId);
	
	@Query("SELECT x FROM AppBorrowing x LEFT JOIN FETCH x.book LEFT JOIN FETCH x.user WHERE x.status = '0' AND x.user.userId = :userId")
	List<AppBorrowing> findByStatus0AndUser(@Param("userId") String userId);
	
	@Query("SELECT x FROM AppBorrowing x LEFT JOIN FETCH x.book LEFT JOIN FETCH x.user WHERE x.status = '1' AND x.user.userId = :userId")
	List<AppBorrowing> findByStatus1AndUser(@Param("userId") String userId);
	
	@Query("SELECT x FROM AppBorrowing x LEFT JOIN FETCH x.book LEFT JOIN FETCH x.user WHERE x.borrowingId = :id")
	AppBorrowing findOneById(@Param("id") Long borrowingId);

}

