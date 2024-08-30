package com.team.safari.Controller;

import com.team.safari.Vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MembersInsertController {
    @GetMapping("/insert")
    public String insertViewMembers(Model model) {
        model.addAttribute("userId", new UserVO());
        return "thymeleafEcoHero/SignUp";
    }
    @PostMapping("/insert")
    public String insertDBMembers(@ModelAttribute("userId") MembersVO membersVO) {
        MembersInsertDAO mInsertDao = new MembersInsertDAO();
        mInsertDao.MembersJoin(membersVO);
        return "thymeleafEcoHero/Join";
    }
}