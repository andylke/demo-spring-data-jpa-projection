package com.github.andylke.demo.spring.account;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
class AccountRepositoryTests {

  @Autowired private AccountRepository accountRepository;

  @Sql(statements = {"insert into account (id, user_code, amount) values(1, 'foo', 12.34)"})
  @Test
  void getByUserCode() {
    Account fooAccount = accountRepository.getByUserCode("foo");
    assertThat(fooAccount.getAmount()).isEqualTo(new BigDecimal("12.34"));
  }
}
