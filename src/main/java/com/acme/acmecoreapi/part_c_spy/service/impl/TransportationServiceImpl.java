package com.acme.acmecoreapi.part_c_spy.service.impl;

import com.acme.acmecoreapi.part_c_spy.service.TransportationService;
import com.acme.acmecoreapi.part_c_spy.service.VehicleService;
import org.springframework.stereotype.Service;

@Service
public class TransportationServiceImpl implements TransportationService {
  @Override
  public void moveVehicle(Long startPosition, Long endPosition, VehicleService vehicleService) {
    if (startPosition < endPosition) {
      vehicleService.moveForward(endPosition - startPosition);
    }
    if (startPosition > endPosition) {
      vehicleService.moveBackward(startPosition - endPosition);
    }
  }
}
