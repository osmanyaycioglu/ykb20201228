package com.training.ykb.rest.design1;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.rest.Person;

@RestController
@RequestMapping("/api/v1/person/d1/search/name")
public class PersonSearchRestD1 {

    @GetMapping
    public List<Person> getByName(@RequestParam("name") final String personName) {
        return null;
    }


}
