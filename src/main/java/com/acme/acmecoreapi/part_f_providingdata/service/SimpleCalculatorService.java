package com.acme.acmecoreapi.part_f_providingdata.service;

import com.acme.acmecoreapi.part_f_providingdata.constant.AppConstants;

public interface SimpleCalculatorService {
  Long calculate(Long number1, AppConstants.Operator operator, Long number2);
}
