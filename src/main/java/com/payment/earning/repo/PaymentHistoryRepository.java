package com.payment.earning.repo;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.earning.model.PaymentHistory;
import com.payment.earning.model.PaymentType;

@Repository
public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, Long> {
    List<PaymentHistory> findByPaymentType(PaymentType paymentType);
	Optional<PaymentHistory> findById(Integer vendor_id);

}
