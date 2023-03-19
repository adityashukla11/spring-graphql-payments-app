package com.app.springgraphqlapp.service.implementation;

import com.app.springgraphqlapp.model.Payment;
import com.app.springgraphqlapp.repository.PaymentRepository;
import com.app.springgraphqlapp.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
  @Autowired
  @Qualifier("fakePaymentRepo")
  private PaymentRepository paymentRepository;

  @Override
  public List<Payment> getAllPayments() {
    return paymentRepository.getAllPayments();
  }

  @Override
  public Payment getPaymentById(Integer id) {
    return paymentRepository.getPaymentById(id).orElseThrow(
            () -> new RuntimeException("Payment with given id " + id + " not found"));
  }

  @Override
  public void createPayment(Payment payment) {
    paymentRepository.save(payment);
  }

  @Override
  public void createPaymentBatch(List<Payment> payments) {
    paymentRepository.saveAll(payments);
  }

}
