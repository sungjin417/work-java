package com.team.safari.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ecohero")
public class MenuController {
    @GetMapping("/menu")
    public String ecoheroMenu() {
        return "thymeleafEcoHero/Home";
    }
}
