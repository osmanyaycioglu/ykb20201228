package com.training.ykb.clients;

import com.training.ykb.model.PaymentRequest;
import com.training.ykb.rest.error.RestException;

public class PaymentFallback implements IPaymentClient {

    @Override
    public String charge(final PaymentRequest prParam) throws RestException {
        return "OK-Fallback";
    }

}
