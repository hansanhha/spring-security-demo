package study.security.this_will_protect_you.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @GetMapping("/email/{email}")
    public String video(@PathVariable("email") String email) {
        return "Allowed for email : " + email;
    }
}
