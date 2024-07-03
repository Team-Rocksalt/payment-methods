package com.zooplus.paymentmethods.services;

import com.zooplus.paymentmethods.services.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * A repository for {@link PaymentMethod}.
 */
@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Integer> {
}
