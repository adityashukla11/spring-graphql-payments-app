package com.app.springgraphqlapp.controllers;

import com.app.springgraphqlapp.model.Payment;
import com.app.springgraphqlapp.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PaymentContoller {
  @Autowired
  private PaymentService paymentService;
  @QueryMapping
  public List<Payment> getAllPayment(){
    return paymentService.getAllPayments();
  }
}
