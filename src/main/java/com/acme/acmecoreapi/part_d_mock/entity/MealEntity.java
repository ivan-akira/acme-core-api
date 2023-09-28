package com.acme.acmecoreapi.part_d_mock.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MealEntity {
  private UUID mealId;

  private String mealName;
}
