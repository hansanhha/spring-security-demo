package study.security.this_will_protect_you.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.security.this_will_protect_you.entity.Token;

import java.util.Optional;

public interface JpaTokenRepository extends JpaRepository<Token, Long> {

    Optional<Token> findTokenByIdentifier(String identifier);
}
