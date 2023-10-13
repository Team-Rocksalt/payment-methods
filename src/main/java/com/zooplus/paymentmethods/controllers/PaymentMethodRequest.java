package com.zooplus.paymentmethods.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A request model for {@link com.zooplus.paymentmethods.controllers.PaymentMethodResource} controller.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethodRequest {

    private String name;
    private String countryCode;
    private boolean countryDefault;
}
