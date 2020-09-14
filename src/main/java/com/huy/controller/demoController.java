package com.huy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class demoController {
    @RequestMapping("/demo/{id}")
    public String viewProduct(@PathVariable int id, Model model){
        model.addAttribute("id",id);
        return "demo";

    }
}
