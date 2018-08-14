package bbs.domain.repository.borrowing;

import org.springframework.data.jpa.repository.JpaRepository;
import bbs.domain.model.AppBorrowing;

public interface AppBorrowingRepository extends JpaRepository<AppBorrowing, Long>{
	
	
}
