package com.training.ykb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import a.b.c.MyBean;

@RestController
//@Controller
//@Repository
//@Service
//@Configuration
public class HelloRest {

    @Autowired
    @Qualifier("ali")
    private IHello hs;

    @Autowired
    private MyBean mbean;

    @GetMapping
    public String hello() {
        return this.hs.hello();
    }

}
