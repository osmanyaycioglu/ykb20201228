package com.training.ykb.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persontest")
public class PersonTestRest {

    @GetMapping("/hello2/{xyz}/{abc}")
    public String hello2(@PathVariable("xyz") final String name,
                         @PathVariable("abc") final String surname) {
        return "Hello 2 " + name + " " + surname;
    }

    @GetMapping("/hello3")
    public String hello3(@RequestParam("xyz") final String name,
                         @RequestParam("abc") final String surname) {
        return "Hello 3 " + name + " " + surname;
    }

    @GetMapping("/hello4/{xyz}")
    public String hello4(@PathVariable("xyz") final String name,
                         @RequestParam("abc") final String surname) {
        return "Hello 4 " + name + " " + surname;
    }

    @GetMapping("/hello5")
    public String hello5(@RequestHeader("xyz") final String name,
                         @RequestHeader("abc") final String surname) {
        return "Hello 5 " + name + " " + surname;
    }

    @PostMapping("/hello6")
    public String hello6(@RequestBody final Person personParam) {
        return "Hello 6 " + personParam;
    }


    @GetMapping("/hello")
    public String helloGet() {
        return "Hello GET";
    }

    @PostMapping("/hello")
    public String helloPost() {
        return "Hello POST";
    }

    @PutMapping("/hello")
    public String helloPut() {
        return "Hello PUT";
    }

    @DeleteMapping("/hello")
    public String helloDelete() {
        return "Hello DELETE";
    }

    @PatchMapping("/hello")
    public String helloPatch() {
        return "Hello PATCH";
    }


}
