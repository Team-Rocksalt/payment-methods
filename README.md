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

| Attribute          | Description                                                                                                   |
|--------------------|---------------------------------------------------------------------------------------------------------------|
| _id_               | payment method id                                                                                             |
| _name_             | payment method name (e.g., "PAYPAL")                                                                          |
| _country code_     | [ISO 3166-1 (alpha-2)](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) country code (e.g., "FR" for France) |
| _country default_  | a boolean flag representing whether the payment method is the default for the related country                 |

#### Supported payment methods

In this application, the following payment methods are considered:
* APPLE_PAY
* MASTERCARD
* VISA
* PAYPAL
* BANK_TRANSFER

### Domain constraints

The following constraints exist for this application:

#### Country code and payment method relationship
1. a country code can be associated to multiple payment methods
2. a country code cannot be associated to more than one payment method with same name

In other words, the following is allowed:

| Insertion order | Payment method name | Country code |
|-----------------|---------------------|--------------|
| ✅ 1             | PAYPAL              | FR           |
| ✅ 2             | VISA                | FR           |

But this is NOT allowed:

| Insertion order  | Payment method name | Country code |
|------------------|---------------------|--------------|
| ✅ 1              | PAYPAL              | FR           |
| ❎ 2 (fails here) | PAYPAL              | FR           |

#### Country default payment method
1. the first payment method added to a country code becomes the country default payment method;
2. at any given time, a country code with at least one payment method should have *ONLY ONE* country default payment method;
3. for a given country code with more than one payment method, if a country default payment method is deleted,
   the payment method with the smallest id is automatically set a country default payment method;

| Insertion order | Country code | Payment methods | Country default | Allowed? |
|-----------------|--------------|-----------------|-----------------|----------|
| 1               | DE           | PAYPAL          | Yes             | ✅ (Yes)  |
| 2               | DE           | VISA            | No              | ✅ (Yes)  |

| Insertion order | Country code | Payment methods | Country default | Allowed?  |
|-----------------|--------------|-----------------|-----------------|-----------|
| 1               | DE           | PAYPAL          | No              | ❎ (No)    |

| Insertion order | Country code | Payment methods | Country default | Allowed? |
|-----------------|--------------|-----------------|-----------------|----------|
| 1               | DE           | PAYPAL          | Yes             | ✅ (Yes)  |
| 2               | DE           | APPLE_PAY       | No              | ✅ (Yes)  |
| 3               | DE           | VISA            | Yes             | ❎ (No)   |
