package com.training.ykb.rest.design2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;
import com.training.ykb.rest.Person;
import com.training.ykb.services.PersonManager;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/person/d2/provision")
@Validated
@Tag(name = "Person-Rest", description = "Person provision api")
public class PersonRestD2 {

    @Autowired
    private PersonManager pm;

    @Operation(description = "Yeni Person add işlemi")
    @PostMapping("/add")
    public String add(@Validated @RequestBody final Person personParam) {
        if (personParam.getHeight() > 250) {
            throw new IllegalArgumentException("Person boyu 250 cm den büyük olamaz");
        }
        return this.pm.addOrUpdate(personParam);
    }

    @GetMapping("/delete")
    public String remove(@NotNull @RequestParam("pid") final Long personId) {
        return this.pm.remove(personId);
    }

    @GetMapping("/get")
    public Person get(@RequestParam("pid") final Long personId) {
        return this.pm.get(personId);
    }

    @PostMapping("/update")
    public String update(@RequestBody final Person personParam) {
        return this.pm.addOrUpdate(personParam);
    }


}

