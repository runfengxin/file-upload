package com.xrf.http.bc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("open")
    public String loginPage(Model model){
        return "upload";
    }
}
