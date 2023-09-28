package com.acme.acmecoreapi.part_d_mock.service.impl;

import com.acme.acmecoreapi.part_d_mock.entity.MealEntity;
import com.acme.acmecoreapi.part_d_mock.service.KitchenService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class KitchenServiceImpl implements KitchenService {
  @Override
  public MealEntity doCookMeal() {
    return MealEntity
      .builder()
      .mealId(UUID.randomUUID())
      .mealName("Pizza")
      .build();
  }
}
