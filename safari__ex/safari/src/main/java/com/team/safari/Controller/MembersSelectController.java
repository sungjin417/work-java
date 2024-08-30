package com.team.safari.Controller;

import com.team.safari.Dao.MembersSelectDAO;
import com.team.safari.Vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/members")
public class MembersSelectController {
    @GetMapping("/select")
    public String MembersSelect(Model model) {
        MembersSelectDAO dao = new MembersSelectDAO();
        List<UserVO> mbsvo = dao.selectMembersInfo();
        model.addAttribute ("userId", mbsvo);
        return "thymeleafEcoHero/Login";
    }

}
