package edu.austral.ingsis.math.operations;

import edu.austral.ingsis.math.*;
import java.util.*;

public class Module implements Function {
  private Function operand;

  public Module(Function operand) {
    this.operand = operand;
  }

  @Override
  public double evaluate(Map<String, Double> variableValues) {
    return Math.abs(operand.evaluate(variableValues));
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
    return "|" + operandPrint + "|";
  }

  @Override
  public int getPrecedence() {
    return 2;
  }
}
