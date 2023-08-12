package com.github.andylke.demo.spring.account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

  public Account getByUserCode(String userCode);
}
