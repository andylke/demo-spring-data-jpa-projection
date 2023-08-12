package com.github.andylke.demo.spring.stock;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {

  public Stock getByProductCode(String productCode);
}
