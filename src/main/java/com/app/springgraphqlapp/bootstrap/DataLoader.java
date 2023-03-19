package com.app.springgraphqlapp.bootstrap;

import com.app.springgraphqlapp.model.Currency;
import com.app.springgraphqlapp.model.Customer;
import com.app.springgraphqlapp.model.Payment;
import com.app.springgraphqlapp.model.PaymentMethod;
import com.app.springgraphqlapp.model.Sales;
import com.app.springgraphqlapp.service.CustomerService;
import com.app.springgraphqlapp.service.PaymentService;
import com.app.springgraphqlapp.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

  @Autowired
  private SalesService salesService;
  @Autowired
  private CustomerService customerService;
  @Autowired
  private PaymentService paymentService;

  @Override
  public void run(String... args) throws Exception {
    Customer customer1 = new Customer(1, "John Smith", "john.smith@example.com", "+1 (123) 456-7890");
    Customer customer2 = new Customer(2, "Jane Doe", "jane.doe@example.com", "+1 (234) 567-8901");
    Customer customer3 = new Customer(3,"Bob Johnson", "bob.johnson@example.com", "+1 (345) 678-9012");
    customerService.createCustomerBatch(Arrays.asList(customer1, customer2, customer3));

    Payment payment1 = new Payment(1, "TXN001", PaymentMethod.CREDIT_CARD, "4111-1111-1111-1111",
            "12/24", "123", 135.00, Currency.USD, "Payment for Sales Order SO1001");
    Payment payment2 = new Payment(2, "TXN002", PaymentMethod.DEBIT_CARD, "4111-2222-2222-2222",
            "12/24", "123", 99.99, Currency.USD, "Payment for Sales Order SO1002");
    Payment payment3 = new Payment(3,"TXN003", PaymentMethod.CREDIT_CARD, "4111-3333-3333-3333",
            "12/26", "321", 10.00, Currency.USD, "Payment for Sales Order SO1003");
    paymentService.createPaymentBatch(Arrays.asList(payment1, payment2, payment3));

    Sales sales1 = new Sales(1,"SO1001", customerService.getCustomerById(1),
            135.00, "pending", paymentService.getPaymentById(1));
    Sales sales2 = new Sales(2, "SO1002", customerService.getCustomerById(2),
            99.99, "processing", paymentService.getPaymentById(2));
    Sales sales3 = new Sales(3, "SO1003", customerService.getCustomerById(3),
            10.00, "complete", paymentService.getPaymentById(3));
    salesService.createSalesBatch(Arrays.asList(sales1, sales2, sales3));
  }
}

