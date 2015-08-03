package org.olmec.sequences;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * In mathematics, the factorial of a non-negative integer n, denoted by n!, is the product of all
 * positive integers less than or equal to n. For example, 5! = 5 x 4 x 3 x 2 x 1 = 120
 *
 * Formula: n! = n * (n − 1)!
 *
 * http://en.wikipedia.org/wiki/Factorial
 *
 * @author t0tec (t0tec.olmec@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class Factorial {

  /**
   * Iterative solution of Factorials
   *
   * @param n the number n to calculate Factorial of n
   * @return the factorial of n
   */
  public int iterative(final int n) {
    validate(n);
    if (n <= 1) {
      return 1;
    }

    int accumulator = 1;
    int i = n;
    while (i >= 2) {
      accumulator *= i;
      i--;
    }

    return accumulator;
  }

  /**
   * Recursive solution of Factorial
   *
   * @param n the number n to calculate Factorial of n
   * @return the factorial of n
   */
  public int recursive(int n) {
    validate(n);
    if (n <= 1) {
      return 1;
    }

    return n * recursive(n - 1);
  }

  /**
   * Tail recursive solution of Factorial
   *
   * @param n the number n to calculate Factorial of n
   * @return the factorial of n
   */
  public int tailRecursive(int n) {
    return tailRecursive(n, 1);
  }

  /**
   * Tail recursive solution of Factorial
   *
   * @param n           the number n to calculate Factorial of n
   * @param accumulator the accumulated numbers that gives us factorial of n
   * @return the factorial of n
   */
  private int tailRecursive(int n, int accumulator) {
    validate(n);
    if (n == 0) {
      return accumulator;
    } else {
      return tailRecursive(n - 1, accumulator * n);
    }
  }

  public int trailingZeros(int n) {
    throw new NotImplementedException();
  }

    /**
     * Validate the given number is not negative
     *
     * @param n the number n to give to sequence Fn
     */
  private void validate(final int n) {
    if (n < 0) {
      throw new IllegalArgumentException("Parameter n must be zero or positive!");
    }
  }
}
