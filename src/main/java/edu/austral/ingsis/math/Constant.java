package edu.austral.ingsis.math;

import java.util.*;

public class Constant implements Function {
  private final double value;

  public Constant(double value) {
    this.value = value;
  }

  @Override
  public double evaluate(Map<String, Double> variableValues) {
    return value;
  }

  @Override
  public List<String> listVariables() {
    return Collections.emptyList();
  }

  public String print() {
    if (value == (long) value) {
      return String.format("%d", (long) value); // Converts to long if no decimals are needed
    } else {
      return String.format("%s", value); // Keeps decimal if present
    }
  }

  @Override
  public int getPrecedence() {
    return Integer.MAX_VALUE;
  }
}
