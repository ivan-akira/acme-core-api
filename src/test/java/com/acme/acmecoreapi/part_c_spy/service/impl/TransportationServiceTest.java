package com.acme.acmecoreapi.part_c_spy.service.impl;

import com.acme.acmecoreapi.part_c_spy.service.VehicleService;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class TransportationServiceTest {
  @InjectMocks
  private TransportationServiceImpl transportationService;

  @Test
  void moveVehicle_EndGreaterThanStartPosition_VehicleMoveForward() {
    // arrange
    Long startPosition = 10L;
    Long endPosition = 13L;
    Long expectedStep = 3L;

    VehicleServiceSpy vehicleService = new VehicleServiceSpy();

    // act
    transportationService.moveVehicle(startPosition, endPosition, vehicleService);

    // assert
    assertEquals(expectedStep, vehicleService.getStepMoveForward());
  }

  @Data
  private static class VehicleServiceSpy implements VehicleService { // <- this is spy
    private Long stepMoveForward;

    @Override
    public void moveForward(Long step) {
      stepMoveForward = step;
    }

    @Override
    public void moveBackward(Long step) {
    }
  }
}
