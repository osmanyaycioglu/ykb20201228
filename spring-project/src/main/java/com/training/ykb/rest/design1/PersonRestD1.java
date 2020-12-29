package com.training.ykb.rest.design1;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.rest.Person;

@RestController
@RequestMapping("/api/v1/person/d1/provision/")
public class PersonRestD1 {

    @PutMapping
    public String add(@RequestBody final Person personParam) {
        return "OK";
    }

    @DeleteMapping
    public String remove(@RequestParam("pid") final Long personId) {
        return "OK";
    }

    @GetMapping
    public Person get(@RequestParam("pid") final Long personId) {
        return null;
    }

    @PostMapping
    public String update(@RequestBody final Person personParam) {
        return "OK";
    }

}
