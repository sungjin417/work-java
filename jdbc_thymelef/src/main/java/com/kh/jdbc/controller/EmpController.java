package com.kh.jdbc.controller;
import com.kh.jdbc.dao.EmpDao;
import com.kh.jdbc.vo.EmpVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {
    @GetMapping("/select")
    public String selectEmp(Model model) { // View로 모델을 넘겨주는 객체
        EmpDao dao = new EmpDao();
        List<EmpVo> emps = dao.empSelect();
        model.addAttribute("employees", emps);
        return "thymeleafEx/empSelect";
    }
    @GetMapping("/insert")
    public String insertViewEmp(Model model) { // View로 모델을 넘겨주는 객체
        model.addAttribute("employees", new EmpVo()); // 빈 객체를 넘겨 줌
        return "thymeleafEx/empInsert";
    }
    @PostMapping("/insert")
    public String insertDBEmp(@ModelAttribute("employees") EmpVo empVO) {
        EmpDao dao = new EmpDao();
        dao.empInsert(empVO);
        return "thymeleafEx/empInsertRst";
    }
}
