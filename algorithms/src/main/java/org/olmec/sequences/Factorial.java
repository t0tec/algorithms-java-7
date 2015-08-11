package org.olmec.sequences;

/**
 * In mathematics, the factorial of a non-negative integer n, denoted by n!, is the product of all
 * positive integers less than or equal to n. For example, 5! = 5 x 4 x 3 x 2 x 1 = 120
 *
 * Formula: n! = n * (n − 1)!
 *
 * http://en.wikipedia.org/wiki/Factorial
 * https://en.wikipedia.org/wiki/Trailing_zero
 *
 * @author t0tec (t0tec.olmec@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class Factorial {

  /**
   * Iterative solution of Factorial
   *
   * @param n the number n to calculate Factorial of n
   * @return the factorial of n
   */
  public long iterative(final int n) {
    validate(n);
    if (n <= 1) {
      return 1L;
    }

    long accumulator = 1L;
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
  public long recursive(int n) {
    validate(n);
    if (n <= 1) {
      return 1L;
    }

    return n * recursive(n - 1);
  }

  /**
   * Tail recursive solution of Factorial
   *
   * @param n the number n to calculate Factorial of n
   * @return the factorial of n
   */
  public long tailRecursive(int n) {
    return tailRecursive(n, 1L);
  }

  /**
   * Tail recursive solution of Factorial
   *
   * @param n           the number n to calculate Factorial of n
   * @param accumulator the accumulated numbers that gives us factorial of n
   * @return the factorial of n
   */
  private long tailRecursive(int n, long accumulator) {
    validate(n);
    if (n == 0) {
      return accumulator;
    } else {
      return tailRecursive(n - 1, accumulator * n);
    }
  }

  /**
   * Calculate the numbers of trailing zeros in n!
   *
   * Suppose n = 128 ==> 128/5 + 128/25 + 128/125 ==> 31 trailing zeros as long as divider (5^x) <=
   * n
   * @param n
   * @return the number of trailing zeros in n! (example 5! = 120 ==> 1 trailing zero)
   */
  public long trailingZeros(final int n) {
    validate(n);

    if (n < 5) {
      return 0L;
    }

    long count = 0L;
    long divider = 5L;
    while (divider <= n) {
      count += n / divider;
      divider *= 5L;
    }

    return count;
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
