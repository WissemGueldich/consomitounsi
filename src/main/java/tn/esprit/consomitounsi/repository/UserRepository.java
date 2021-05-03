package tn.esprit.consomitounsi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.consomitounsi.modal.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
	User findByUsername(String username);
	boolean existsByUsername(String username);
	boolean existsByEmail(String email);
	Optional<User> findByUsernameOrEmail(String usernameOrEmail, String usernameOrEmail2);

}
