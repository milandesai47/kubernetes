package com.example.kubernetes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWorldController {

    @RequestMapping("/")
    public String index() {
        return "index.html" ;
    }
}
