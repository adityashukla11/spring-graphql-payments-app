package com.app.springgraphqlapp.service.implementation;

import com.app.springgraphqlapp.model.Customer;
import com.app.springgraphqlapp.repository.CustomerRepository;
import com.app.springgraphqlapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
  @Autowired
  @Qualifier("fakeCustomerRepo")
  private CustomerRepository customerRepository;

  @Override
  public List<Customer> getAllCustomers() {
    return customerRepository.getAllCustomers();
  }

  @Override
  public Customer getCustomerById(Integer id) {
    return customerRepository.getCustomerById(id).orElseThrow(
            () -> new RuntimeException("Customer with given id " + id + " not found"));
  }

  @Override
  public void createCustomer(Customer customer) {
    customerRepository.save(customer);
  }

  @Override
  public void createCustomerBatch(List<Customer> customers) {
    customerRepository.saveAll(customers);
  }
}
