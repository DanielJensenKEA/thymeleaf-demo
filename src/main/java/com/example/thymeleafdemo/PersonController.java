package com.example.thymeleafdemo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class PersonController {

    @GetMapping
    public String getPeople(Model model) {
        model.addAttribute("attribute1FraJava", "this is coming from the controller");
        model.addAttribute("attribute2FraJava", "this is also coming from the controller");
        model.addAttribute("people", Arrays.asList(
                new Person("John", 20),
                new Person("Sarah", 22),
                new Person("Simon", 23)));
        return "people"; //returnerer .html template
    }

}
