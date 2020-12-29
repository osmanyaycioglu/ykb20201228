package com.training.ykb;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Qualifier("ali")
//@Scope("prototype")
public class HelloService implements IHello {

    @Value("${app.hello.str}")
    private String helloStr;

    @Override
    public String hello() {
        return this.helloStr;
    }

}
