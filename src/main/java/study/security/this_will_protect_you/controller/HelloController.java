package study.security.this_will_protect_you.controller;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import study.security.this_will_protect_you.config.SecurityUser;
import study.security.this_will_protect_you.entity.Authorities;
import study.security.this_will_protect_you.entity.User;
import study.security.this_will_protect_you.repository.AuthoritiesRepository;
import study.security.this_will_protect_you.repository.UserRepository;

@RestController
public class HelloController {

    private final AuthoritiesRepository authoritiesRepository;
    private final UserRepository userRepository;

    private final UserDetailsManager userDetailsManager;

    public HelloController(AuthoritiesRepository authoritiesRepository, UserRepository userRepository, UserDetailsManager userDetailsManager) {
        this.authoritiesRepository = authoritiesRepository;
        this.userRepository = userRepository;
        this.userDetailsManager = userDetailsManager;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/save")
    public String save() {
        userDetailsManager.createUser(new SecurityUser(new User(1L, "testUser", "1234", 1)));
        authoritiesRepository.save(new Authorities("testUser", "write"));
//        userRepository.save(new User("testUser", "1234", 1));
        return "created data";
    }

    @GetMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("home.html");
    }

}
