package study.security.this_will_protect_you.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.stereotype.Repository;
import study.security.this_will_protect_you.entity.Token;
import study.security.this_will_protect_you.repository.JpaTokenRepository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class CustomCsrfTokenRepository implements CsrfTokenRepository {

    private final JpaTokenRepository jpaTokenRepository;

    public CustomCsrfTokenRepository(JpaTokenRepository jpaTokenRepository) {
        this.jpaTokenRepository = jpaTokenRepository;
    }

    @Override
    public CsrfToken generateToken(HttpServletRequest request) {
        String uuid = UUID.randomUUID().toString();
        return new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf", uuid);
    }

    @Override
    public void saveToken(CsrfToken token, HttpServletRequest request, HttpServletResponse response) {
        String identifier = request.getHeader("X-IDENTIFIER");
        Optional<Token> existingToken = jpaTokenRepository.findTokenByIdentifier(identifier);

        if (existingToken.isPresent()) {
            Token existToken = existingToken.get();
            existToken.setToken(token.getToken());
        } else {
            Token newToken = new Token();
            newToken.setToken(token.getToken());
            newToken.setIdentifier(identifier);
            jpaTokenRepository.save(newToken);
        }
    }

    @Override
    public CsrfToken loadToken(HttpServletRequest request) {
        String identifier = request.getHeader("X-IDENTIFIER");

        Optional<Token> existingToken = jpaTokenRepository.findTokenByIdentifier(identifier);

        if (existingToken.isPresent()) {
            Token token = existingToken.get();
            return new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf", token.getToken());
        }

        return null;
    }
}
