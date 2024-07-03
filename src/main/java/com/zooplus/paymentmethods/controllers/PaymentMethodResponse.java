package com.zooplus.paymentmethods.controllers;

/**
 * A response model for {@link com.zooplus.paymentmethods.controllers.PaymentMethodResource} controller.
 */
public class PaymentMethodResponse {
    private int id;
    private String name;
    private String countryCode;
    private boolean countryDefault;

    public PaymentMethodResponse() {}

    public PaymentMethodResponse(int id, String name, String countryCode, boolean countryDefault) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.countryDefault = countryDefault;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public boolean isCountryDefault() {
        return countryDefault;
    }

    public static PaymentMethodResponse.Builder builder() {
        return new PaymentMethodResponse.Builder();
    }

    public static class Builder {
        private int id;
        private String name;
        private String countryCode;
        private boolean countryDefault;

        public PaymentMethodResponse build() {
            return new PaymentMethodResponse(this.id, this.name, this.countryCode, this.countryDefault);
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder countryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public Builder countryDefault(boolean countryDefault) {
            this.countryDefault = countryDefault;
            return this;
        }
    }
}
