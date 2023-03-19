package com.app.springgraphqlapp.service;

import com.app.springgraphqlapp.model.Customer;

import java.util.List;

public interface CustomerService {
  List<Customer> getAllCustomers();

  Customer getCustomerById(Integer id);

  void createCustomer(Customer customer);

  void createCustomerBatch(List<Customer> customers);
}
