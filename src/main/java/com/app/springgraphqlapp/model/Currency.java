package com.app.springgraphqlapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Currency {
  USD("US Dollar"),
  EUR("Euro");
  private final String name;
}
