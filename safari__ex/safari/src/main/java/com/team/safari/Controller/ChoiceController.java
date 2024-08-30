package com.team.safari.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class ChoiceController {
    @Controller
    @RequestMapping("/feed")
    public class ChoiceController {
        @GetMapping("/select")
        public String feedSelect(Model model) {
            feedDAO fdao = new feedDAO();
            List<FeedVO> mvl = fdao.feedSelect();
            model.addAttribute("feeds",mvl);
            return "thymeleafEcoHero/Choice";
        }
        @GetMapping("/insert")
        public String feedInsert(Model model) {
            model.addAttribute("newfeed", new FeedVO());
            return "thymeleafEcoHero/feedInsert";
        }

        @PostMapping("/insert")
        public String insertDBFeed(@ModelAttribute("newfeed") FeedVO feedVO) {
            feedDAO fdao = new feedDAO();
            fdao.insertFeed(feedVO);
            return "thymeleafEcoHero/feedInsertRst";
        }
        @GetMapping("/choice1")
        public String choice1(Model model) {
            feedDAO fdao = new feedDAO();
            List<FeedVO> mvl = fdao.feedSelect();
            model.addAttribute("feeds",mvl);
            return "thymeleafEcoHero/Animal";
        }
        @GetMapping("/choice2")
        public String choice2(Model model) {
            feedDAO fdao = new feedDAO();
            List<FeedVO> mvl = fdao.feedSelect();
            model.addAttribute("feeds",mvl);
            return "thymeleafEcoHero/Plants";
        }
        @GetMapping("/choice3")
        public String choice3(Model model) {
            feedDAO fdao = new feedDAO();
            List<FeedVO> mvl = fdao.feedSelect();
            model.addAttribute("feeds",mvl);
            return "thymeleafEcoHero/Aquarium";
        }

    }
}
