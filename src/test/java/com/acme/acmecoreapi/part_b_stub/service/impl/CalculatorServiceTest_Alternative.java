package com.acme.acmecoreapi.part_b_stub.service.impl;

import com.acme.acmecoreapi.part_b_stub.entity.ComplexNumberDTO;
import lombok.Builder;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class CalculatorServiceTest_Alternative {
  @InjectMocks
  private CalculatorServiceImpl calculatorService;

  @Test
  void add_PositiveComplexNumber_ReturnPositiveComplexNumber() {
    // arrange
    ComplexNumberDTO number1 = ComplexNumberDTOStub.builder().number(1L).build();
    ComplexNumberDTO number2 = ComplexNumberDTOStub.builder().number(3L).build();
    Long expectedResult = 4L;

    // act
    ComplexNumberDTO result = calculatorService.add(number1, number2);

    // assert
    Assertions.assertEquals(expectedResult, result.getNumber());
  }

  @Data
  @Builder
  private static class ComplexNumberDTOStub implements ComplexNumberDTO { // <- this is stub
    private Long number;
  }
}
