package com.github.andylke.demo.purchaseorder;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class PurchaseOrder {

  @Id @GeneratedValue private Long id;

  @Column(unique = true)
  @NotBlank
  private String userCode;

  @Column(unique = true)
  @NotBlank
  private String productCode;

  @NotNull private Integer count;

  @NotNull private BigDecimal amount;
}
