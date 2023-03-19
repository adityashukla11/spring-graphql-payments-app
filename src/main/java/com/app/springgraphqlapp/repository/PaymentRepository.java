package com.app.springgraphqlapp.repository;

import com.app.springgraphqlapp.model.Payment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fakePaymentRepo")
public class PaymentRepository {
  private List<Payment> payments = new ArrayList<>();

  public List<Payment> getAllPayments() {
    return payments;
  }

  public Optional<Payment> getPaymentById(Integer id) {
    return payments.stream().filter(payment -> payment.getId() == id).findFirst();
  }

  public void save(Payment payment) {
    payments.add(payment);
  }

  public void saveAll(List<Payment> payments) {
    this.payments.addAll(payments);
  }

}
