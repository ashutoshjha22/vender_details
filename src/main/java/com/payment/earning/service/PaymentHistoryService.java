package com.payment.earning.service;



import java.util.List;

import com.payment.earning.model.PaymentHistory;
import com.payment.earning.model.PaymentType;

public interface PaymentHistoryService {
    List<PaymentHistory> getAllPayments();
    List<PaymentHistory> getPaymentsByType(PaymentType paymentType);
    PaymentHistory getPaymentById(Long id);
    PaymentHistory createPayment(PaymentHistory paymentHistory);
    PaymentHistory updatePayment(Long id, PaymentHistory paymentHistory);
    void deletePayment(Long id);
}
