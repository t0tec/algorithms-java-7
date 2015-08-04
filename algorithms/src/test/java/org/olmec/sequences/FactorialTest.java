package org.olmec.sequences;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author t0tec (t0tec.olmec@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class FactorialTest {

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNegativeValuesRecursive() {
    new Factorial().recursive(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNegativeValuesTailRecursive() {
    new Factorial().tailRecursive(-1);
  }


  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNegativeValuesIterative() {
    new Factorial().iterative(-1);
  }

  @Test
  public void zeroFactorialRecursive() {
    assertEquals(1, new Factorial().recursive(0));
  }

  @Test
  public void zeroFactorialTailRecursive() {
    assertEquals(1, new Factorial().tailRecursive(0));
  }

  @Test
  public void zeroFactorialIterative() {
    assertEquals(1, new Factorial().iterative(0));
  }

  @Test
  public void fiveFactorialRecursive() {
    assertEquals(120, new Factorial().recursive(5));
  }

  @Test
  public void fiveFactorialTailRecursive() {
    assertEquals(120, new Factorial().tailRecursive(5));
  }

  @Test
  public void fiveFactorialIterative() {
    assertEquals(120, new Factorial().iterative(5));
  }

  @Test
  public void tenFactorialRecursive() {
    assertEquals(3628800, new Factorial().recursive(10));
  }

  @Test
  public void tenFactorialTailRecursive() {
    assertEquals(3628800, new Factorial().tailRecursive(10));
  }

  @Test
  public void tenFactorialIterative() {
    assertEquals(3628800, new Factorial().iterative(10));
  }

  @Test
  public void fifteenFactorialRecursive() {
    assertEquals(1307674368000L, new Factorial().recursive(15));
  }

  @Test
  public void fifteenFactorialTailRecursive() {
    assertEquals(1307674368000L, new Factorial().tailRecursive(15));
  }

  @Test
  public void fifteenFactorialIterative() {
    assertEquals(1307674368000L, new Factorial().iterative(15));
  }


  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNegativeValuesTrailingZeros() {
    new Factorial().trailingZeros(-1);
  }

  @Test
  public void trailingNumbersZeroFactorial() {
    assertEquals(0, new Factorial().trailingZeros(0));
  }

  @Test
  public void trailingNumbersFiveFactorial() {
    assertEquals(1, new Factorial().trailingZeros(5));
  }

  @Test
  public void trailingNumbersHugeFactorial() {
    assertEquals(31, new Factorial().trailingZeros(128));
  }
}
