package com.app.springgraphqlapp.repository;

import com.app.springgraphqlapp.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fakeCustomerRepo")
public class CustomerRepository {
  private List<Customer> customers = new ArrayList<>();

  public List<Customer> getAllCustomers() {
    return customers;
  }

  public Optional<Customer> getCustomerById(Integer id) {
    return customers.stream().filter(customer -> customer.getId() == id).findFirst();
  }

  public void save(Customer customer) {
    customers.add(customer);
  }

  public void saveAll(List<Customer> customers) {
    this.customers.addAll(customers);
  }

}
