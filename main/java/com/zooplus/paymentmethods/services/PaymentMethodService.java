package com.zooplus.paymentmethods.services;

import com.zooplus.paymentmethods.controllers.PaymentMethodRequest;
import com.zooplus.paymentmethods.controllers.PaymentMethodResponse;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides service for {@link PaymentMethod}.
 */
@Service
public class PaymentMethodService {

    @Resource
    private PaymentMethodRepository paymentMethodRepository;

    /**
     * Returns a list of all payment methods.
     *
     * @return list of all payment methods
     */
    public List<PaymentMethodResponse> getPaymentMethods() {
        List<PaymentMethodResponse> responseList = new ArrayList<>();
        List<PaymentMethod> paymentMethods = paymentMethodRepository.findAll();
        for (PaymentMethod pm : paymentMethods) {
            responseList.add(PaymentMethodResponse.builder()
                    .id(pm.getId())
                    .name(pm.getName())
                    .countryCode(pm.getCountryCode())
                    .build());
        }
        return responseList;
    }

    /**
     * Adds a new payment method as described by {@code paymentMethodRequest}.
     *
     * @param paymentMethodRequest a request containing description of new payment method to be added
     * @return a response containing details of the newly added payment method
     */
    public PaymentMethodResponse addPaymentMethod(PaymentMethodRequest paymentMethodRequest) {
        PaymentMethod savedPaymentMethod = paymentMethodRepository.save(PaymentMethod.builder()
                .countryCode(paymentMethodRequest.countryCode())
                .countryDefault(paymentMethodRequest.countryDefault())
                .name(paymentMethodRequest.name())
                .build());
        return PaymentMethodResponse.builder()
                .id(savedPaymentMethod.getId())
                .name(savedPaymentMethod.getName())
                .countryCode(savedPaymentMethod.getCountryCode())
                .countryDefault(paymentMethodRequest.countryDefault())
                .build();
    }
}
