package edu.austral.ingsis.math;

import java.util.*;

public interface Function {
  double evaluate(Map<String, Double> variableValues);

  List<String> listVariables();

  String print();

  public int getPrecedence();
}
