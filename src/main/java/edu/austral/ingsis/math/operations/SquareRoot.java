package edu.austral.ingsis.math.operations;

import edu.austral.ingsis.math.*;
import java.util.*;

public class SquareRoot implements Function {
  private final Function operand;

  public SquareRoot(Function operand) {
    this.operand = operand;
  }

  @Override
  public double evaluate(Map<String, Double> variableValues) {
    return Math.sqrt(operand.evaluate(variableValues));
  }

  @Override
  public List<String> listVariables() {
    return operand.listVariables();
  }

  @Override
  public String print() {
    String operandPrint =
        operand.getPrecedence() <= this.getPrecedence()
            ? "(" + operand.print() + ")"
            : operand.print();
    return "sqrt(" + operandPrint + ")";
  }

  @Override
  public int getPrecedence() {
    return 3;
  }
}
