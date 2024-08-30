package com.safari.safari.controller;


import com.safari.safari.dao.MembersInsertDAO;
import com.safari.safari.vo.MembersVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MembersInsertController {
    @GetMapping("/insert")
    public String insertViewMembers(Model model) {
        model.addAttribute("userId", new MembersVO());
        return "thymeleafSafari/SignUp";
    }
    @PostMapping("/insert")
    public String insertDBMembers(@ModelAttribute("userId") MembersVO membersVO) {
        MembersInsertDAO mInsertDao = new MembersInsertDAO();
        mInsertDao.MembersJoin(membersVO);
        return "thymeleafSafari/Join";
    }
}
