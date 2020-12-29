package com.training.ykb;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import a.b.c.MyConfig;

@Configuration
@Import(MyConfig.class)
public class HelloConfig {

    @Bean
    @Qualifier("veli")
    public IHello helloBean() {
        return new HelloService();
    }

}
