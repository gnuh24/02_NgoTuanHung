package com.example.demoSpring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloBro")
public class Demo {
    @GetMapping
    public String hello(){
        return "HelloWorld";
    }
}
