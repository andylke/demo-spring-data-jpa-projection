package com.github.andylke.demo.spring.purchaseorder;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
class PurchaseOrderRepositoryTests {

  @Autowired private PurchaseOrderRepository purchaseOrderRepository;

  @Sql(
      statements = {
        "insert into purchase_order (id, user_code, product_code, count, amount) values(1, 'foo', 'bar', 1, 12.34)"
      })
  @Test
  void getByUserCodeAndProductCode() {
    PurchaseOrder order = purchaseOrderRepository.getByUserCodeAndProductCode("foo", "bar");
    assertThat(order.getAmount()).isEqualTo(new BigDecimal("12.34"));
  }

  @Sql(
      statements = {
        "insert into purchase_order (id, user_code, product_code, count, amount) values(1, 'foo', 'bar', 1, 12.34)",
        "insert into stock (id, product_code, count) values(1, 'bar', 12)"
      })
  @Test
  void getPurchaseOrderAndRemainingStock() {
    PurchaseOrderAndRemainingStock orderAndStock =
        purchaseOrderRepository.getPurchaseOrderAndRemainingStock("foo", "bar");
    assertThat(orderAndStock.getPurchaseAmount()).isEqualTo(new BigDecimal("12.34"));
    assertThat(orderAndStock.getRemainingCount()).isEqualTo(12);
  }

  @Sql(
      statements = {
        "insert into purchase_order (id, user_code, product_code, count, amount) values(1, 'foo', 'bar', 1, 12.34)"
      })
  @Test
  void getSummaryByUserCode() {
    PurchaseOrderSummary summary = purchaseOrderRepository.getSummaryByUserCode("foo");
    assertThat(summary.getTotalPurchaseCount()).isEqualTo(1);
  }
}
