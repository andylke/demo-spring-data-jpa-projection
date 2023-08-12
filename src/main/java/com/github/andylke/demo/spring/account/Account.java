package com.github.andylke.demo.spring.account;

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
public class Account {

  @Id @GeneratedValue private Long id;

  @Column(unique = true)
  @NotBlank
  private String userCode;

  @NotNull private BigDecimal amount;
}
