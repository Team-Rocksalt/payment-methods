package com.zooplus.paymentmethods.controllers;

/**
 * A request model for {@link PaymentMethodResource} controller.
 */
public record PaymentMethodRequest(String name, String countryCode, boolean countryDefault) {

}
