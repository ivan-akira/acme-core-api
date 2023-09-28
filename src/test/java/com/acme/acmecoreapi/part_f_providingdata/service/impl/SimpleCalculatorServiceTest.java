package com.acme.acmecoreapi.part_f_providingdata.service.impl;

import com.acme.acmecoreapi.part_f_providingdata.constant.AppConstants;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class SimpleCalculatorServiceTest {
  @InjectMocks
  private SimpleCalculatorServiceImpl simpleCalculatorService;

  @ParameterizedTest
  @ValueSource(longs = {1L, 2L, 3L})
  void calculate_ZeroAddedWithPositiveNumber_ReturnPositiveNumber(long number2) {
    // arrange
    long number1 = 0;

    // act
    Long result = simpleCalculatorService.calculate(number1, AppConstants.Operator.ADD, number2);

    // assert
    assertEquals(1, Math.signum(result));
  }

  @ParameterizedTest
  @EnumSource(AppConstants.Operator.class)
  void calculate_AllOperationForBothZeroNumber_ReturnZeroNumber(AppConstants.Operator operator) {
    // arrange
    Long number1 = 0L;
    Long number2 = 0L;

    // act
    Long result = simpleCalculatorService.calculate(number1, operator, number2);

    // assert
    assertEquals(0, result);
  }

  @ParameterizedTest
  @CsvSource(delimiter = ',', textBlock = """
    -1, -1, -2
     1,  1,  2
    """)
  void calculate_AddBothNumberWithCsvSource_ReturnExpectedNumberResult(
    Long number1,
    Long number2,
    Long expectedResult) {
    // arrange

    // act
    Long result = simpleCalculatorService.calculate(number1, AppConstants.Operator.ADD, number2);

    // assert
    assertEquals(expectedResult, result);
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
  void calculate_AddBothNumberWithCsvFileSource_ReturnExpectedNumberResult(
    Long number1,
    Long number2,
    Long expectedResult) {
    // arrange

    // act
    Long result = simpleCalculatorService.calculate(number1, AppConstants.Operator.ADD, number2);

    // assert
    assertEquals(expectedResult, result);
  }

  @ParameterizedTest
  @MethodSource("provideCalculateWithBothNumber")
  void calculate_BothNumber_ReturnExpectedNumberResult(
    Long number1,
    AppConstants.Operator operator,
    Long number2,
    Long expectedResult) {
    // arrange

    // act
    Long result = simpleCalculatorService.calculate(number1, operator, number2);

    // assert
    assertEquals(expectedResult, result);
  }

  private static Stream<Arguments> provideCalculateWithBothNumber() {
    return Stream.of(
      Arguments.of(-1L, AppConstants.Operator.ADD, -1L, -2L),
      Arguments.of(1L, AppConstants.Operator.ADD, 1L, 2L),
      Arguments.of(-1L, AppConstants.Operator.SUBSTRACT, -1L, 0L),
      Arguments.of(1L, AppConstants.Operator.SUBSTRACT, 1L, 0L));
  }
}
