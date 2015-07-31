package org.olmec.sequences;

import org.junit.Ignore;
import org.junit.Test;

import java.math.BigInteger;
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
    assertEquals(BigInteger.valueOf(55), new Fibonacci(10, true).calculate());
  }

  @Test
  public void twentiethNumberInFibonacciSequenceRecursive() {
    assertEquals(BigInteger.valueOf(6765), new Fibonacci(20, true).calculate());
  }

  @Test
  public void twentyFifthNumberInFibonacciSequenceRecursive() {
    assertEquals(BigInteger.valueOf(75025), new Fibonacci(25, true).calculate());
  }

  @Test
  @Ignore("Recursive is too slow or stuck?")
  public void fiftiethNumberInFibonacciSequenceRecursive() {
    assertEquals(BigInteger.valueOf(12586269025L), new Fibonacci(50, true).calculate());
  }

  @Test
  public void firstElevenFibonacciSequenceNumbersRecursive() {
    BigInteger[] expected = new BigInteger[11];
    expected[0] = BigInteger.ZERO;
    expected[1] = BigInteger.ONE;

    for (int i = 2; i < expected.length; i++) {
      expected[i] = expected[i - 2].add(expected[i - 1]);
    }

    assertArrayEquals(expected, new Fibonacci(10, true).getSequence());
  }

  @Test
  public void fibonacciSequenceNumbersLowerThanEightRecursive() {
    BigInteger[] expected = new BigInteger[6];

    expected[0] = BigInteger.ZERO;
    expected[1] = BigInteger.ONE;

    for (int i = 2; i < expected.length; i++) {
      expected[i] = expected[i - 2].add(expected[i - 1]);
    }

    List<BigInteger> list = new Fibonacci(8, true).getSequenceLowerThanN();

    BigInteger[] result = list.toArray(new BigInteger[list.size()]);

    assertArrayEquals(expected, result);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNegativeValuesIterative() {
    new Fibonacci(-1, false).calculate();
  }

  @Test
  public void tenthNumberInFibonacciSequenceIterative() {
    assertEquals(new BigInteger("55"), new Fibonacci(10, false).calculate());
  }

  @Test
  public void twentiethNumberInFibonacciSequenceIterative() {
    assertEquals(new BigInteger("6765"), new Fibonacci(20, false).calculate());
  }

  @Test
  public void twentyFifthNumberInFibonacciSequenceIterative() {
    assertEquals(new BigInteger("75025"), new Fibonacci(25, false).calculate());
  }

  @Test
  public void fiftiethNumberInFibonacciSequenceIterative() {
    assertEquals(new BigInteger("12586269025"), new Fibonacci(50, false).calculate());
  }

  @Test
  public void firstElevenFibonacciSequenceNumbersIterative() {
    BigInteger[] expected = new BigInteger[11];
    expected[0] = BigInteger.ZERO;
    expected[1] = BigInteger.ONE;

    for (int i = 2; i < expected.length; i++) {
      expected[i] = expected[i - 2].add(expected[i - 1]);
    }

    assertArrayEquals(expected, new Fibonacci(10, false).getSequence());
  }

  @Test
  public void fibonacciSequenceNumbersLowerThanEightIterative() {
    BigInteger[] expected = new BigInteger[6];

    expected[0] = BigInteger.ZERO;
    expected[1] = BigInteger.ONE;

    for (int i = 2; i < expected.length; i++) {
      expected[i] = expected[i - 2].add(expected[i - 1]);
    }

    List<BigInteger> list = new Fibonacci(8, false).getSequenceLowerThanN();

    BigInteger[] result = list.toArray(new BigInteger[list.size()]);

    assertArrayEquals(expected, result);
  }
}
