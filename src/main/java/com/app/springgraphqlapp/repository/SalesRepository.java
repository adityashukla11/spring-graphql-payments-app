package com.app.springgraphqlapp.repository;

import com.app.springgraphqlapp.model.Sales;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fakeSalesRepo")
public class SalesRepository {
  private List<Sales> sales = new ArrayList<>();

  public List<Sales> getAllSales() {
    return sales;
  }

  public Optional<Sales> getSalesById(Integer id) {
    return sales.stream().filter(sales -> sales.getId() == id)
            .findFirst();
  }

  public void save(Sales sale) {
    sales.add(sale);
  }

  public void saveAll(List<Sales> sales) {
    this.sales.addAll(sales);
  }
}
