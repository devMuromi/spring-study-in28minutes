package com.devmuromi.learnoauth;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {

    @GetMapping("/hello-world")
    public String helloWorld(Authentication authentication) {
//        System.out.println(authentication);
        System.out.println(authentication.getPrincipal());
        return "Hello world";
    }

}
