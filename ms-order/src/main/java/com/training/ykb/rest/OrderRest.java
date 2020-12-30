package com.training.ykb.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.model.Order;
import com.training.ykb.rest.error.RestException;
import com.training.ykb.services.OrderService;

@RestController
@RequestMapping("/api/v1/order")
public class OrderRest {

    @Autowired
    private OrderService os;

    @PostMapping("/place")
    public String placeOrder(@Validated @RequestBody final Order order) {
        return this.os.placeOrder(order);
    }

    @PostMapping("/place2")
    public String placeOrder2(@Validated @RequestBody final Order order) throws RestException {
        return this.os.placeOrder2(order);
    }

}
