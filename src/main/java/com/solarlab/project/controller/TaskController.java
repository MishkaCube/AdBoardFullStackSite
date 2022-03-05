package com.solarlab.project.controller;

import com.solarlab.project.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/people")
public class TaskController {
    private final PersonDto personDto;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", personDto.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,
                       Model model) {
        model.addAttribute("person", personDto.show(id));
        return "people/show ";
    }
}
