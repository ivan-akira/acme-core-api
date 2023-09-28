package com.acme.acmecoreapi.part_b_stub.service.impl;

import com.acme.acmecoreapi.part_b_stub.entity.ComplexNumberDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class CalculatorServiceTest {
  @InjectMocks
  private CalculatorServiceImpl calculatorService;

  @Test
  void add_PositiveComplexNumber_ReturnPositiveComplexNumber() {
    // arrange
    ComplexNumberDTO number1 = new OneComplexNumberDTOStub();
    ComplexNumberDTO number2 = new ThreeComplexNumberDTOStub();
    Long expectedResult = 4L;

    // act
    ComplexNumberDTO result = calculatorService.add(number1, number2);

    // assert
    assertEquals(expectedResult, result.getNumber());
  }

  private static class OneComplexNumberDTOStub implements ComplexNumberDTO { // <- this is stub
    @Override
    public Long getNumber() {
      return 1L;
    }
  }

  private static class ThreeComplexNumberDTOStub implements ComplexNumberDTO { // <- this is stub
    @Override
    public Long getNumber() {
      return 3L;
    }
  }
}
