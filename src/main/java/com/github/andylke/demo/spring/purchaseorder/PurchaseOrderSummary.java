package com.github.andylke.demo.spring.purchaseorder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PurchaseOrderSummary {

  private String userCode;

  private long totalPurchaseCount;
}
