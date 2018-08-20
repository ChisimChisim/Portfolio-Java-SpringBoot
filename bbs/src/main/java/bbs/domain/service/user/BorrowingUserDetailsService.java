package bbs.domain.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import bbs.domain.model.User;
import bbs.domain.repository.user.UserRepository;

@Service
public class BorrowingUserDetailsService implements UserDetailsService{
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userId)
	       throws UsernameNotFoundException{
		User user = userRepository.findOneByUserId(userId);
		if (user == null) {
			throw new UsernameNotFoundException(userId + "is not found.");	
		}
		
		return new BorrowingUserDetails(user);
	}
	
}
