package study.security.this_will_protect_you.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.security.this_will_protect_you.entity.Authorities;
import study.security.this_will_protect_you.entity.User;
import study.security.this_will_protect_you.repository.AuthoritiesRepository;
import study.security.this_will_protect_you.repository.UserRepository;

@RestController
public class HelloController {

    private final AuthoritiesRepository authoritiesRepository;
    private final UserRepository userRepository;

    public HelloController(AuthoritiesRepository authoritiesRepository, UserRepository userRepository) {
        this.authoritiesRepository = authoritiesRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/save")
    public String save() {
        authoritiesRepository.save(new Authorities("testUser", "write"));
        userRepository.save(new User("testUser", "1234", 1));
        return "created data";
    }
}
