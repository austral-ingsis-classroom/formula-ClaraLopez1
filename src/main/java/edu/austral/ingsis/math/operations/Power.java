package edu.austral.ingsis.math.operations;

import edu.austral.ingsis.math.*;
import java.util.*;

public class Power implements Function {
  private final Function base;
  private final Function exponent;

  public Power(Function base, Function exponent) {
    this.base = base;
    this.exponent = exponent;
  }

  @Override
  public double evaluate(Map<String, Double> variableValues) {
    return Math.pow(base.evaluate(variableValues), exponent.evaluate(variableValues));
  }

  @Override
  public List<String> listVariables() {
    List<String> variables = new ArrayList<>();
    variables.addAll(base.listVariables());
    variables.addAll(exponent.listVariables());
    return variables;
  }

  @Override
  public String print() {
    String basePrint =
        base.getPrecedence() <= this.getPrecedence() ? "(" + base.print() + ")" : base.print();
    String exponentPrint =
        exponent.getPrecedence() <= this.getPrecedence()
            ? "(" + exponent.print() + ")"
            : exponent.print();
    return basePrint + " ^ " + exponentPrint;
  }

  @Override
  public int getPrecedence() {
    return 3;
  }
}
