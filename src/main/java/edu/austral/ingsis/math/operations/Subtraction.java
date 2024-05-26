package edu.austral.ingsis.math.operations;

import edu.austral.ingsis.math.*;
import java.util.*;

public class Subtraction implements Function {
  private final Function left;
  private final Function right;

  public Subtraction(Function left, Function right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public double evaluate(Map<String, Double> variableValues) {
    return left.evaluate(variableValues) - right.evaluate(variableValues);
  }

  @Override
  public List<String> listVariables() {
    List<String> variables = new ArrayList<>();
    variables.addAll(left.listVariables());
    variables.addAll(right.listVariables());
    return variables;
  }

  @Override
  public String print() {
    String leftPrint =
        (left instanceof Module || left instanceof Variable || left instanceof Constant)
            ? left.print()
            : "(" + left.print() + ")";
    String rightPrint =
        (right instanceof Variable || right instanceof Constant)
            ? right.print()
            : "(" + right.print() + ")";
    return leftPrint + " - " + rightPrint;
  }

  @Override
  public int getPrecedence() {
    return 1;
  }
}
