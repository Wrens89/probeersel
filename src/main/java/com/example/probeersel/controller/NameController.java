package com.example.probeersel.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class NameController {

    //attribute
    private List<String> names = new ArrayList<>();

    //constructor
    public NameController() {
        names.add("Johan");
        names.add("Peter");
        names.add("Henk");
    }

    @GetMapping(value = "/names")
    public  List<String> getNames() {
        return names;
    }

    @GetMapping(value = "/names/{id}")
    public String getName(@PathVariable int id) {
        return names.get(id);
    }

    @DeleteMapping(value = "/names/{id}")
    public  void deleteName(@PathVariable int id) {
        names.remove(id);
    }

    @PostMapping(value = "/names")
    public String addName(@RequestBody String name) {
        names.add(name);
        return "Added!";
    }

}
