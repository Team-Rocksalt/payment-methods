package com.zooplus.paymentmethods.services;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

/**
 * Represents the Zooplus payment method entity.
 */
@Entity
@Table(name = "PAYMENT_METHOD", schema = "ZOOPLUS")
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "country_default")
    private boolean countryDefault;

    public PaymentMethod() {
    }

    public PaymentMethod(Integer id, String name, String countryCode, boolean countryDefault) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.countryDefault = countryDefault;
    }

    public Integer getId() {
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

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentMethod that = (PaymentMethod) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public static class Builder {
        private Integer id;
        private String name;
        private String countryCode;
        private boolean countryDefault;

        public Builder id(Integer id) {
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

        public PaymentMethod build() {
            return new PaymentMethod(this.id, this.name, this.countryCode, this.countryDefault);
        }
    }
}
