package com.app.springgraphqlapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sales {

  private Integer id;
  private String orderNumber;
  private Customer customer;
  private Double total;
  private String status;
  private Payment payment;
}