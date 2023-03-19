package com.app.springgraphqlapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

  private Integer id;
  private String transactionId;
  private PaymentMethod paymentMethod;
  private String cardNumber;
  private String expirationDate;
  private String cvv;
  private double amount;
  private Currency currency;
  private String description;
}
