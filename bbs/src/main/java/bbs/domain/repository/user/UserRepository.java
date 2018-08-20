package bbs.domain.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bbs.domain.model.User;

public interface UserRepository extends JpaRepository<User, String>{
	@Query("SELECT x FROM User x WHERE x.userId = :userId")
	User findOneByUserId(@Param("userId") String userId);

}
