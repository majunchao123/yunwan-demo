package com.mjc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author:majunchao
 * @date:2022/7/5 9:44
 */
@Controller
public class LoginController {

    @PostMapping("/toMain")
    public String toMain(){
        return "redirect:main.html";
    }

    @PostMapping("/toError")
    public String toError(){
        return "redirect:error.html";
    }
}
