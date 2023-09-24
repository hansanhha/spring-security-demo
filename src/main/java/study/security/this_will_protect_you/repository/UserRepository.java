package study.security.this_will_protect_you.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.security.this_will_protect_you.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUsername(String u);
}
