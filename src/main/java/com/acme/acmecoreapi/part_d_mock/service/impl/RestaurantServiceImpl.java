package com.acme.acmecoreapi.part_d_mock.service.impl;

import com.acme.acmecoreapi.part_d_mock.entity.MealEntity;
import com.acme.acmecoreapi.part_d_mock.service.KitchenService;
import com.acme.acmecoreapi.part_d_mock.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
  @Autowired
  private KitchenService kitchenService;

  @Override
  public List<MealEntity> orderTakeoutMeals(int quantity) {
    List<MealEntity> meals = new ArrayList<>();

    for (int i = 0; i < quantity; i++) {
      MealEntity meal = kitchenService.doCookMeal();

      if (meal != null) {
        meals.add(meal);
      }
    }

    return meals;
  }
}
