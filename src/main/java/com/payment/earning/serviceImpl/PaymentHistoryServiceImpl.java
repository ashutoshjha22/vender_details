package com.payment.earning.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.earning.model.PaymentHistory;
import com.payment.earning.model.PaymentType;
import com.payment.earning.repo.PaymentHistoryRepository;
import com.payment.earning.service.PaymentHistoryService;

@Service
public class PaymentHistoryServiceImpl implements PaymentHistoryService {

    @Autowired
    private PaymentHistoryRepository paymentHistoryRepository;

    @Override
    public List<PaymentHistory> getAllPayments() {
        return paymentHistoryRepository.findAll();
    }

    @Override
    public List<PaymentHistory> getPaymentsByType(PaymentType paymentType) {
        return paymentHistoryRepository.findByPaymentType(paymentType);
    }

    @Override
    public PaymentHistory getPaymentById(Long id) {
        return paymentHistoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    @Override
    public PaymentHistory createPayment(PaymentHistory paymentHistory) {
        return paymentHistoryRepository.save(paymentHistory);
    }

    @Override
    public PaymentHistory updatePayment(Long id, PaymentHistory paymentHistory) {
        PaymentHistory existingPayment = getPaymentById(id);
        existingPayment.setServiceName(paymentHistory.getServiceName());
        existingPayment.setAmount(paymentHistory.getAmount());
        existingPayment.setDateTime(paymentHistory.getDateTime());
        existingPayment.setPaymentType(paymentHistory.getPaymentType());
        return paymentHistoryRepository.save(existingPayment);
    }

    @Override
    public void deletePayment(Long id) {
        paymentHistoryRepository.deleteById(id);
    }
}
