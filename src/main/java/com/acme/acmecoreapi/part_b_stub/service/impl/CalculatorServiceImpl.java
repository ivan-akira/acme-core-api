package com.acme.acmecoreapi.part_b_stub.service.impl;

import com.acme.acmecoreapi.part_b_stub.entity.ComplexNumberDTO;
import com.acme.acmecoreapi.part_b_stub.service.CalculatorService;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
  @Override
  public ComplexNumberDTO add(ComplexNumberDTO number1, ComplexNumberDTO number2) {
    return ComplexNumber
      .builder()
      .number(number1.getNumber() + number2.getNumber())
      .build();
  }

  @Data
  @Builder
  private static class ComplexNumber implements ComplexNumberDTO {
    private Long number;
  }
}
