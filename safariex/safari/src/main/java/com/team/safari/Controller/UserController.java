package com.team.safari.Controller;

import com.team.safari.Service.SelectionService;
import com.team.safari.Service.UserService;
import com.team.safari.Vo.InformationVO;
import com.team.safari.Vo.UserVO;
import com.team.safari.Vo.UserSelectionVO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class UserController {

    private final UserService userService;
    private final SelectionService selectionService;

    public UserController(UserService userService, SelectionService selectionService) {
        this.userService = userService;
        this.selectionService = selectionService;
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserVO user) {
        userService.registerUser(user);
        return "redirect:/selection";
    }

    @PostMapping("/selection")
    public String saveSelection(@ModelAttribute("selection") UserSelectionVO selection) {
        selectionService.saveSelection(selection);
        return "redirect:/information";
    }

    @GetMapping("/information")
    public String getInformation(@RequestParam("userId") String userId, Model model) {
        List<InformationVO> informationVOList = selectionService.getInformationByUser(userId);
        model.addAttribute("informationList", informationVOList);
        return "information";
    }
}