package study.security.this_will_protect_you.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloController {


    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @PostMapping("/hello")
    public String postHello() {
        return "Post Hello!";
    }

    @GetMapping("/ciao")
    public String ciao() {
        return "Ciao";
    }

}
