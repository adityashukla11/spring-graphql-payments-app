package com.app.springgraphqlapp.controllers;

import com.app.springgraphqlapp.model.Sales;
import com.app.springgraphqlapp.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SalesController {
  @Autowired
  private SalesService salesService;
  @QueryMapping
  public List<Sales> getAllSales() {
    return salesService.getAllSales();
  }

  @QueryMapping
  public Sales getSalesById(@Argument Integer id) {
    return salesService.getSalesById(id);
  }
}
