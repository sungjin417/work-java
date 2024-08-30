package com.safari.safari.controller;

import com.safari.safari.dao.feedDAO;
import com.safari.safari.vo.FeedVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/choice")
public class ChoiceController {
    @GetMapping("/select")
    public String feedSelect(Model model) {
        feedDAO fdao = new feedDAO();
        List<FeedVO> mvl = fdao.feedSelect();
        model.addAttribute("feeds",mvl);
        return "thymeleafSafari/choice";
    }
    @GetMapping("/insert")
    public String feedInsert(Model model) {
        model.addAttribute("newfeed", new FeedVO());
        return "thymeleafSafari/feedInsert";
    }

    @PostMapping("/insert")
    public String insertDBFeed(@ModelAttribute("newfeed") FeedVO feedVO) {
        feedDAO fdao = new feedDAO();
        fdao.insertFeed(feedVO);
        return "thymeleafSafari/feedInsertRst";
    }
    @GetMapping("/choice1")
    public String choice1(Model model) {
        feedDAO fdao = new feedDAO();
        List<FeedVO> mvl = fdao.feedSelect();
        model.addAttribute("feeds",mvl);
        return "thymeleafSafari/Animal";
    }
    @GetMapping("/choice2")
    public String choice2(Model model) {
        feedDAO fdao = new feedDAO();
        List<FeedVO> mvl = fdao.feedSelect();
        model.addAttribute("feeds",mvl);
        return "thymeleafSafari/Plants";
    }
    @GetMapping("/choice3")
    public String choice3(Model model) {
        feedDAO fdao = new feedDAO();
        List<FeedVO> mvl = fdao.feedSelect();
        model.addAttribute("feeds",mvl);
        return "thymeleafSafari/Aquarium";
    }

}