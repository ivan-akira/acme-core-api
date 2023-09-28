package com.acme.acmecoreapi.part_a_dummy.service.impl;

import com.acme.acmecoreapi.part_a_dummy.strategy.MovementStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class MoveRobotServiceTest {
  @InjectMocks
  private MoveRobotServiceImpl moveRobotService;

  @Test
  void move_PositiveStep_ReturnCorrectPosition() {
    // arrange
    Long initialPosition = 10L;
    Long step = 3L;
    Long expectedPosition = 13L;

    MovementStrategy movementStrategy = new MovementStrategyDummy();

    moveRobotService.setInitialPosition(initialPosition);

    // act
    Long result = moveRobotService.move(step, movementStrategy);

    // assert
    assertEquals(expectedPosition, result);
  }

  private static class MovementStrategyDummy implements MovementStrategy { // <- this is dummy
    @Override
    public void move(Long currentPosition, Long nextPosition) {
    }
  }
}
