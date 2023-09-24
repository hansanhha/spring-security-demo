package study.security.this_will_protect_you.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import study.security.this_will_protect_you.service.ProductService;

@RestController
public class MainController {

    private final ProductService productService;

    public MainController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/loginMain")
    public String loginMain(Authentication a) {
        String message = "Connect success" + "\n"
                + "Hello " + a.getName() + "\n";
        return message;
    }

    @GetMapping("/main")
    public ModelAndView main() {
        return new ModelAndView("main.html");
    }
}
