package com.acme.acmecoreapi.part_a_dummy.service;

import com.acme.acmecoreapi.part_a_dummy.strategy.MovementStrategy;

public interface MoveRobotService {
  void setInitialPosition(Long position);

  Long move(Long step, MovementStrategy movementStrategy);
}
