package edu.austral.ingsis.math;

import java.util.*;

public class Variable implements Function {

  private final String name;

  public Variable(String name) {
    this.name = name;
  }

  @Override
  public double evaluate(Map<String, Double> variableValues) {
    if (variableValues.containsKey(name)) {
      return variableValues.get(name);
    }
    throw new IllegalArgumentException("Variable " + name + " not found in the map");
  }

  @Override
  public List<String> listVariables() {
    return Collections.singletonList(name);
  }

  @Override
  public String print() {
    return name;
  }

  @Override
  public int getPrecedence() {
    return Integer.MAX_VALUE;
  }
}
