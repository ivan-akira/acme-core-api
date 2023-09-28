package com.acme.acmecoreapi.part_c_spy.service;

public interface TransportationService {
  void moveVehicle(Long startPosition, Long endPosition, VehicleService vehicleService);
}
