package com.acme.acmecoreapi.part_d_mock.service;

import com.acme.acmecoreapi.part_d_mock.entity.MealEntity;

import java.util.List;

public interface RestaurantService {
  List<MealEntity> orderTakeoutMeals(int quantity);
}
