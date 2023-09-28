package com.acme.acmecoreapi.part_f_providingdata.service.impl;

import com.acme.acmecoreapi.part_f_providingdata.constant.AppConstants;
import com.acme.acmecoreapi.part_f_providingdata.service.SimpleCalculatorService;
import org.springframework.stereotype.Service;

@Service
public class SimpleCalculatorServiceImpl implements SimpleCalculatorService {
  @Override
  public Long calculate(Long number1, AppConstants.Operator operator, Long number2) {
    if (operator == AppConstants.Operator.ADD) {
      return number1 + number2;
    }
    if (operator == AppConstants.Operator.SUBSTRACT) {
      return number1 - number2;
    }
    return null;
  }
}
