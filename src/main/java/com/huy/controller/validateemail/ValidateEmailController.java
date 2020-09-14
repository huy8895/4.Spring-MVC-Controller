package com.huy.controller.validateemail;

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
        return "validateemail";
    }
    @PostMapping("/validate")
    String validateEmail(@RequestParam("email") String email, Model model) {
        boolean isvalid = this.validate(email);
        if (!isvalid) {
            model.addAttribute("message", "Email is invalid");
            model.addAttribute("isvalid", isvalid);

        } else {
            model.addAttribute("message", "Email is validate");
            model.addAttribute("isvalid", isvalid);
        }
        return "validateemail";

    }

    private boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

}
