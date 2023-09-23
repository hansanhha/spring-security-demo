package study.security.this_will_protect_you.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.security.this_will_protect_you.entity.Authorities;

public interface AuthoritiesRepository extends JpaRepository<Authorities, Long> {
}
