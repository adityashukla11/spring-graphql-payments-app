package com.app.springgraphqlapp.service;

import com.app.springgraphqlapp.model.Sales;

import java.util.List;

public interface SalesService {
  List<Sales> getAllSales();

  Sales getSalesById(Integer id);

  void createSales(Sales sales);

  void createSalesBatch(List<Sales> customers);
}
