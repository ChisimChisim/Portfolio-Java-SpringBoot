package bbs.domain.service.borrowing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bbs.domain.model.AppBorrowing;
import bbs.domain.repository.borrowing.AppBorrowingRepository;

@Service
@Transactional
public class AppBorrowingService {
	@Autowired
	AppBorrowingRepository appBorrowingRepository;
	
	
}
