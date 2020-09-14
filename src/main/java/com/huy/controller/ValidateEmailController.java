package com.huy.controller;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class ValidateEmailController {
    public static Pattern pattern;
    public static Matcher matcher;

    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public ValidateEmailController() {
        pattern = pattern.compile(EMAIL_REGEX);
    }

    @GetMapping("/index")
    public String getIndex(){
        return "index";
    }
    @PostMapping("/validate")
    String validateEmail(@RequestParam("email") String email, Model model) {
        boolean isvalid = this.validate(email);
        if (!isvalid) {
            model.addAttribute("message", "Email is invalid");
            return "index";
        }

        model.addAttribute("email", email);
        String success = "success";
        model.addAttribute("success",success);
        return "index";
    }

    private boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

}
