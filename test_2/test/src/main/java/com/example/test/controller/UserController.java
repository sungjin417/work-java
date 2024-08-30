package com.example.test.controller;

import com.example.test.dao.UserDAOImpl;
import com.example.test.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/select")
    public String selectEmp(Model model) {
        UserDAOImpl dao = new UserDAOImpl();
        List<UserVO> user = dao.userSelect();
        model.addAttribute("employees", user);
        return "thymeleafEx/empSelect";
    }

}
