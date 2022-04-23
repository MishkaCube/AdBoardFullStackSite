package com.solarlab.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import springfox.documentation.annotations.ApiIgnore;

@Controller
public class SwaggerController {
        @ApiIgnore
        @RequestMapping(value = "/")
        public RedirectView index() {
            return new RedirectView("/swagger-ui.html");
        }
}
