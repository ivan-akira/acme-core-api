package com.acme.acmecoreapi.part_c_spy.service.impl;

import com.acme.acmecoreapi.part_c_spy.service.VehicleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class TransportationServiceTest_Alternative {
  @InjectMocks
  private TransportationServiceImpl transportationService;

  @Mock
  private VehicleService vehicleService; // <- this is spy

  @Test
  void moveVehicle_EndGreaterThanStartPosition_VehicleMoveForward() {
    // arrange
    Long startPosition = 10L;
    Long endPosition = 13L;
    Long expectedStep = 3L;

    // act
    transportationService.moveVehicle(startPosition, endPosition, vehicleService);

    // assert
    verify(vehicleService, times(1)).moveForward(expectedStep);
  }
}
