package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.operations.*;
import edu.austral.ingsis.math.operations.Module;
import java.util.*;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    final Double result =
        new Addition(new Constant(1), new Variable("x")).evaluate(Map.of("x", 3d));

    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    final Double result =
        new Division(new Constant(12), new Variable("div")).evaluate(Map.of("div", 4d));

    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    final Double result =
        new Multiplication(new Division(new Constant(9), new Variable("x")), new Variable("y"))
            .evaluate(Map.of("x", 3d, "y", 4d));

    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    final Double result =
        new Power(new Division(new Constant(27), new Variable("a")), new Variable("b"))
            .evaluate(Map.of("a", 9d, "b", 3d));

    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    final Double result = new SquareRoot(new Variable("z")).evaluate(Map.of("z", 36d));

    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    final Double result =
        new Subtraction(new Module(new Variable("value")), new Constant(8))
            .evaluate(Map.of("value", 8d));

    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    final Double result =
        new Subtraction(new Module(new Variable("value")), new Constant(8))
            .evaluate(Map.of("value", 8d));

    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    final Double result =
        new Multiplication(new Subtraction(new Constant(5), new Variable("i")), new Constant(8))
            .evaluate(Map.of("i", 2d));

    assertThat(result, equalTo(24d));
  }
}
