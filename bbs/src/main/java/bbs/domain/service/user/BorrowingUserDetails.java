package bbs.domain.service.user;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import bbs.domain.model.User;

public class BorrowingUserDetails implements UserDetails {
	private final User user;

	public BorrowingUserDetails(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		return AuthorityUtils.createAuthorityList("ROLE_" + this.user.getRoleName().name());
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}
	
	@Override
	public String getUsername() {
		return this.user.getUserId();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
}
