package com.acme.acmecoreapi.part_d_mock.service.impl;

import com.acme.acmecoreapi.part_d_mock.entity.MealEntity;
import com.acme.acmecoreapi.part_d_mock.service.KitchenService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class RestaurantServiceTest {
  @InjectMocks
  private RestaurantServiceImpl restaurantService;

  @Mock
  private KitchenService kitchenService; // <- this is mock

  @Test
  void orderTakeoutMeals_OrderOneMeal_ReceiveOneMeal() {
    // arrange
    int quantity = 1;
    int expectedQuantity = 1;

    when(kitchenService.doCookMeal()).thenReturn(MealEntity.builder().build());

    // act
    List<MealEntity> result = restaurantService.orderTakeoutMeals(quantity);

    // assert
    assertEquals(expectedQuantity, result.size());
  }
}
