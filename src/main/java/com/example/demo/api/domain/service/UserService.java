package com.example.demo.api.domain.service;

import com.example.demo.api.infra.mapper.BudgetMapper;
import com.example.demo.api.infra.mapper.ShoppingMapper;
import com.example.demo.api.infra.mapper.UserMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
  @NonNull private final UserMapper userMapper;

  @NonNull private final BudgetMapper budgetMapper;

  @NonNull private final ShoppingMapper shoppingMapper;

  @Transactional(rollbackFor = {Exception.class})
  public void modifyUserBy() {
    userMapper.selectUser();

    budgetMapper.updateBudget();

    shoppingMapper.updateShopping();
  }
}
