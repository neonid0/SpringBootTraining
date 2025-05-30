package com.neonid0.springboottraining.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HomeController {

    @GetMapping("/")
    public String greet(HttpServletRequest request) {
        return "Welcome to web site. Here is your session ID:  " + request.getSession().getId();
    }

    @GetMapping("/about")
    public String about(HttpServletRequest request){
        return "This is a web site created by neonid0. Session ID:  " + request.getSession().getId();
    }
}
