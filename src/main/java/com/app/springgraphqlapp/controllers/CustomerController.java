package com.app.springgraphqlapp.controllers;

import com.app.springgraphqlapp.model.Customer;
import com.app.springgraphqlapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CustomerController {
  @Autowired
  private CustomerService customerService;

  @QueryMapping
  public List<Customer> getAllCustomers() {
    return customerService.getAllCustomers();
  }
}
