package com.christianoette.usertypedemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class IndexController {
    @RequestMapping("/")
    public RedirectView redirectToSwagger() {
        return new RedirectView("swagger-ui/index.html");
    }
}
