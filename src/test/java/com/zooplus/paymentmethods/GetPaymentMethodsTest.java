package com.zooplus.paymentmethods;

import com.zooplus.paymentmethods.services.PaymentMethod;
import com.zooplus.paymentmethods.services.PaymentMethodRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class GetPaymentMethodsTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @BeforeEach
    void setup() {
        paymentMethodRepository.save(PaymentMethod.builder()
                .id(1)
                .name("PAYPAL")
                .countryCode("FR")
                .countryDefault(true)
                .build());
    }

    @Test
    void getPaymentMethods_bug() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/payment-methods")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("PAYPAL"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].countryCode").value("FR"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].countryDefault").value(true));
    }
}
