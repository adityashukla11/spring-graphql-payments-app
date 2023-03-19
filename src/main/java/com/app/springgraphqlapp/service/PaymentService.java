package com.app.springgraphqlapp.service;

import com.app.springgraphqlapp.model.Payment;

import java.util.List;

public interface PaymentService {
  List<Payment> getAllPayments();

  Payment getPaymentById(Integer id);

  void createPayment(Payment payment);

  void createPaymentBatch(List<Payment> customers);
}
