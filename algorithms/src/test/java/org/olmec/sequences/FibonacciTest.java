package org.olmec.sequences;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author t0tec (t0tec.olmec@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class FibonacciTest {

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNegativeValuesRecursive() {
    new Fibonacci(-1, true).calculate();
  }

  @Test
  public void tenthNumberInFibonacciSequenceRecursive() {
    assertEquals(55, new Fibonacci(10, true).calculate());
  }

  @Test
  public void twentiethNumberInFibonacciSequenceRecursive() {
    assertEquals(6765, new Fibonacci(20, true).calculate());
  }

  @Test
  public void twentyFifthNumberInFibonacciSequenceRecursive() {
    assertEquals(75025, new Fibonacci(25, true).calculate());
  }

  @Test
  public void firstElevenFibonacciSequenceNumbersRecursive() {
    int[] expected = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55};

    assertArrayEquals(expected, new Fibonacci(10, true).getSequence());
  }

  @Test
  public void fibonacciSequenceNumbersLowerThanOrEqualToEightRecursive() {
    Integer[] expected = {0, 1, 1, 2, 3, 5, 8};

    List<Integer> list = new Fibonacci(8, true).getSequenceLowerThanN();

    Integer[] result = list.toArray(new Integer[list.size()]);

    assertArrayEquals(expected, result);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNegativeValuesIterative() {
    new Fibonacci(-1, false).calculate();
  }

  @Test
  public void tenthNumberInFibonacciSequenceIterative() {
    assertEquals(55, new Fibonacci(10, false).calculate());
  }

  @Test
  public void twentiethNumberInFibonacciSequenceIterative() {
    assertEquals(6765, new Fibonacci(20, false).calculate());
  }

  @Test
  public void twentyFifthNumberInFibonacciSequenceIterative() {
    assertEquals(75025, new Fibonacci(25, false).calculate());
  }

  @Test
  public void firstElevenFibonacciSequenceNumbersIterative() {
    int[] expected = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55};

    assertArrayEquals(expected, new Fibonacci(10, false).getSequence());
  }

  @Test
  public void fibonacciSequenceNumbersLowerThanOrEqualToEightIterative() {
    Integer[] expected = {0, 1, 1, 2, 3, 5, 8};

    List<Integer> list = new Fibonacci(8, false).getSequenceLowerThanN();

    Integer[] result = list.toArray(new Integer[list.size()]);

    assertArrayEquals(expected, result);
  }
}
