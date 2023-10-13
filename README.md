# Zooplus Payment Method application

This application provides capabilities to manage payment methods offered by Zooplus shops.

---

## Technical information

### Requirements

The following is required for this application to run:
* Java JDK 17

### How to

#### Execute tests

> In terminal, run the command: `./mvnw test`

#### Run application

> In terminal, run the command: `./mvnw spring-boot:run`

---

## Domain model

The domain model is very simple:

### Payment Method

| Attribute          | Description                                                                                                  |
|--------------------|--------------------------------------------------------------------------------------------------------------|
| _id_               | payment method id                                                                                            |
| _name_             | payment method name (e.g., "PAYPAL")                                                                         |
| _country code_     | [ISO 3166-1 (alpha-2)](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) country code (e.g., "FR" for France) |
| _country default_  | a boolean flag representing whether the payment method is the default for the related country                |

#### Supported payment methods

In this application, the following payment methods are considered:
* APPLE_PAY
* MASTERCARD
* VISA
* PAYPAL
* BANK_TRANSFER

### Domain constraints

The following constraints exist for this application:

#### Country and payment method relationship
1. a country can be associated to multiple payment methods
2. a country cannot be associated to more than one payment method with same name

| Country | Payment method 1 | Payment method 2 | Allowed? |
|---------|------------------|------------------|----------|
| France  | PAYPAL           | VISA             | (Yes) ✅  |
| France  | PAYPAL           | PAYPAL           | (No) ❎   |

#### Country default payment method
1. the first payment method added to a country becomes the country default payment method;
2. at any given time, a country with at least one payment method should have *ONLY ONE* country default payment method;
3. for a given country with more than one payment method, if a country default payment method is deleted,
   the payment method with the smallest id is automatically set a country default payment method;

| Country | Payment methods | Country default | Allowed? |
|---------|-----------------|-----------------|----------|
| Germany | PAYPAL          | PAYPAL          | (Yes) ✅  |
| Germany | PAYPAL, VISA    | PAYPAL          | (Yes) ✅  |
| Germany | PAYPAL          | -none-          | (No) ❎   |
| Germany | PAYPAL, VISA    | -none-          | (No) ❎   |
| Germany | PAYPAL, VISA    | PAYPAL, VISA    | (No) ❎   |
