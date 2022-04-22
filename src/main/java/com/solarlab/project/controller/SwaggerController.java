package com.solarlab.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

public class SwaggerController {
    @Controller
    public class HomeController {

        @RequestMapping("/")
        public String index() {
            return "redirect:swagger-ui.html";
        }
    }

}
