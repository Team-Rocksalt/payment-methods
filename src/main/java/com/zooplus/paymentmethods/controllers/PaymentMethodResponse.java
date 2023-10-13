package com.zooplus.paymentmethods.controllers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A response model for {@link com.zooplus.paymentmethods.controllers.PaymentMethodResource} controller.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethodResponse {

    private int id;
    private String name;
    private String countryCode;
    private boolean countryDefault;
}
