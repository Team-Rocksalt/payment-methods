package com.zooplus.paymentmethods.controllers;

import com.zooplus.paymentmethods.services.PaymentMethod;
import com.zooplus.paymentmethods.services.PaymentMethodService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for {@link PaymentMethod} resource.
 */
@RestController
@RequestMapping(value = "/payment-methods")
public class PaymentMethodResource {

    @Resource
    private PaymentMethodService paymentMethodService;

    /**
     * Returns a list containing all existing payment methods, with their respective attributes.
     *
     * @return a list of {@link PaymentMethodResponse}
     */
    @GetMapping
    public ResponseEntity<List<PaymentMethodResponse>> getPaymentMethods() {

        return ResponseEntity.ok(paymentMethodService.getPaymentMethods());
    }

    /**
     * Adds a new {@link PaymentMethod}.
     *
     * @param paymentMethodRequest a request containing attributes of the payment method to be added
     * @return a {@link PaymentMethodResponse} with details of the newly added payment method
     */
    @PostMapping(consumes = "application/json")
    public ResponseEntity<PaymentMethodResponse> addPaymentMethod(
            @RequestBody PaymentMethodRequest paymentMethodRequest) {

        return ResponseEntity.ok(paymentMethodService.addPaymentMethod(paymentMethodRequest));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deletePaymentMethod(
            @PathVariable(value = "id", required = true) int id) {

        // TODO
        return ResponseEntity.internalServerError().build();
    }
}
