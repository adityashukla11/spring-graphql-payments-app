package com.app.springgraphqlapp.service.implementation;

import com.app.springgraphqlapp.model.Sales;
import com.app.springgraphqlapp.repository.SalesRepository;
import com.app.springgraphqlapp.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {
  @Autowired
  @Qualifier("fakeSalesRepo")
  private SalesRepository salesRepository;

  @Override
  public List<Sales> getAllSales() {
    return salesRepository.getAllSales();
  }

  @Override
  public Sales getSalesById(Integer id) {
    return salesRepository.getSalesById(id).orElseThrow(
            () -> new RuntimeException("Sales with given id " + id + " not found"));
  }

  @Override
  public void createSales(Sales sales) {
    salesRepository.save(sales);
  }

  @Override
  public void createSalesBatch(List<Sales> sales) {
    salesRepository.saveAll(sales);
  }
}
