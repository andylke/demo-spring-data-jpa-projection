package com.github.andylke.demo.spring.stock;

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
public class Stock {

  @Id @GeneratedValue private Long id;

  @Column(unique = true)
  @NotBlank
  private String productCode;

  @NotNull private Integer count;
}
