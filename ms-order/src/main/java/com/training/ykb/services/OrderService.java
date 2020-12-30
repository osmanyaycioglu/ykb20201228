package com.training.ykb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.training.ykb.clients.IPaymentClient;
import com.training.ykb.model.Order;
import com.training.ykb.model.PaymentRequest;
import com.training.ykb.rest.error.RestException;

@Service
public class OrderService {

    @Autowired
    private RestTemplate   rt;

    @Autowired
    private IPaymentClient pc;

    @Autowired
    private EurekaClient   ec;

    public String placeOrder(final Order order) {
        PaymentRequest pay = new PaymentRequest();
        pay.setCustomerId("JHKJH-JKHKH");
        pay.setAmount(100);
        String postForObjectLoc = this.rt.postForObject("http://ACCOUNTING/api/v1/payment/charge",
                                                        pay,
                                                        String.class);
        return postForObjectLoc;
    }

    public String placeOrder2(final Order order) throws RestException {
        PaymentRequest pay = new PaymentRequest();
        pay.setCustomerId("JHKJH-JKHKH");
        pay.setAmount(order.getAmount());
        return this.pc.charge(pay);
    }


    public String placeOrder3(final Order order) {
        Application applicationLoc = this.ec.getApplication("ACCOUNTING");
        List<InstanceInfo> instancesLoc = applicationLoc.getInstances();
        for (InstanceInfo instanceInfoLoc : instancesLoc) {
            System.out.println(instanceInfoLoc);
        }
        InstanceInfo instanceLoc = this.ec.getNextServerFromEureka("ACCOUNTING",
                                                                   false);
        PaymentRequest pay = new PaymentRequest();
        pay.setCustomerId("JHKJH-JKHKH");
        pay.setAmount(100);
        RestTemplate rtl = new RestTemplate();
        String postForObjectLoc = rtl.postForObject("http://"
                                                    + instanceLoc.getIPAddr()
                                                    + ":"
                                                    + instanceLoc.getPort()
                                                    + "/api/v1/payment/charge",
                                                    pay,
                                                    String.class);
        return postForObjectLoc;
    }

}
