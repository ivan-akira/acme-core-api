package com.acme.acmecoreapi.part_f_providingdata.constant;

public class AppConstants {
  private AppConstants() {
  }

  public enum Operator {
    ADD("Add"),
    SUBSTRACT("Substract");

    private final String description;

    Operator(String description) {
      this.description = description;
    }

    public String getDescription() {
      return description;
    }
  }
}
