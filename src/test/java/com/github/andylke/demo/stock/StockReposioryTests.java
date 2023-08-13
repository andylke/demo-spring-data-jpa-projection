package com.github.andylke.demo.stock;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import com.github.andylke.demo.stock.Stock;
import com.github.andylke.demo.stock.StockRepository;

@DataJpaTest
class StockReposioryTests {

  @Autowired private StockRepository stockRepository;

  @Sql(statements = {"insert into stock (id, product_code, count) values(1, 'bar', 12)"})
  @Test
  void getByProductCode() {
    Stock stock = stockRepository.getByProductCode("foo");
    assertThat(stock.getCount()).isEqualTo(12);
  }
}
