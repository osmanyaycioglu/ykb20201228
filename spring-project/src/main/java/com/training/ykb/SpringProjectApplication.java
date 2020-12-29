package com.training.ykb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//@SpringBootApplication(scanBasePackages = {
//                                            "com.training.ykb",
//                                            "a.b.c"
//})
@SpringBootApplication
@ServletComponentScan
public class SpringProjectApplication {

    @Autowired
    @Qualifier("ali")
    private IHello       hello;
    private final IHello hello2;
    private IHello       hello3;

    @Autowired
    public SpringProjectApplication(@Qualifier("veli") final IHello helloParam) {
        this.hello2 = helloParam;
        helloParam.hello();
    }

    @Autowired
    public void xyz(@Qualifier("veli") final IHello helloParam) {
        this.hello3 = helloParam;
    }

    @PostConstruct
    public void init() {
        this.hello.hello();
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy");
    }

    public static void main(final String[] args) {
        SpringApplication.run(SpringProjectApplication.class,
                              args);
    }

}
