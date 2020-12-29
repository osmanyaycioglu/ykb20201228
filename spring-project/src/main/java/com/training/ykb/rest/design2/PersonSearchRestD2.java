package com.training.ykb.rest.design2;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import com.training.ykb.rest.Person;
import com.training.ykb.services.PersonManager;

@RestController
@RequestMapping("/api/v1/person/d2/search")
public class PersonSearchRestD2 {

    @Autowired
    private PersonManager pm;

    @GetMapping("/name")
    public List<Person> getByName(@RequestParam("name") final String personName) {
        return this.pm.searchByName(personName);
    }

    @GetMapping("/all")
    public List<Person> getAll() {
        return this.pm.getAll();
    }

    @GetMapping("/surname")
    public List<Person> getBySurname(@RequestParam("surname") final String personSurname,
                                     final HttpServletRequest sr,
                                     final Headers header) {
        return this.pm.searchByName(personSurname);
    }

}
