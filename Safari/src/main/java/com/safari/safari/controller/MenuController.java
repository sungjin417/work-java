package com.safari.safari.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("safari")
public class MenuController {
    @GetMapping("/home")
    public String safariMenu() {
        return "thymeleafSafari/Home";
    }
}
