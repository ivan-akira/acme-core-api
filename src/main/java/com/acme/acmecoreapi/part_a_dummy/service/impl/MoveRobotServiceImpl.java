package com.acme.acmecoreapi.part_a_dummy.service.impl;

import com.acme.acmecoreapi.part_a_dummy.service.MoveRobotService;
import com.acme.acmecoreapi.part_a_dummy.strategy.MovementStrategy;
import org.springframework.stereotype.Service;

@Service
public class MoveRobotServiceImpl implements MoveRobotService {
  private Long position;

  @Override
  public void setInitialPosition(Long position) {
    this.position = position;
  }

  @Override
  public Long move(Long step, MovementStrategy movementStrategy) {
    Long currentPosition = position;
    Long nextPosition = currentPosition + step;

    movementStrategy.move(currentPosition, nextPosition);

    return nextPosition;
  }
}
