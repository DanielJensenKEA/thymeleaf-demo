package com.example.thymeleafdemo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

@Controller
public class PersonController {
    private List<Person> list = Arrays.asList(new Person("John", 20),
            new Person("Sarah", 22),
            new Person("Simon", 23));

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

    @GetMapping("/searchForm")
    public String showSearchForm() {
        return "search";
    }

    @GetMapping("/search")
    public String searchPeople(@RequestParam("name") String name, Model model) {
        List<Person> filteredPeople = new ArrayList<>();
        for (Person p : list) {
            if (name.equalsIgnoreCase(p.getName())) {
                filteredPeople.add(p);
            }
        }
        model.addAttribute("filteredPeople", filteredPeople);
        return "searchResults";
    }

}
