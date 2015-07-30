package org.olmec.sequences;

import java.util.ArrayList;
import java.util.List;

/**
 * In mathematics, the Fibonacci numbers or Fibonacci sequence are the numbers in the following
 * integer sequence:
 *
 * 0,1,1,2,3,5,8,13,21,34,55 ...
 *
 * http://en.wikipedia.org/wiki/Fibonacci_number
 *
 * @author t0tec (t0tec.olmec@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class Fibonacci {

  private final int n;
  private final boolean recursive;

  /**
   *
   * @param n the number n to give to sequence Fn
   * @param recursive calculate Fibonacci number(s) recursive and otherwise iterative
   */
  public Fibonacci(int n, boolean recursive) {
    validate(n);
    this.n = n;
    this.recursive = recursive;
  }

  /**
   * Calculates the Fn sequence number
   * @return the Fn sequence number
   */
  public int calculate() {
    return recursive ? recursive(n) : iterative(n);
  }

  /**
   * Recursive solution based on Fibonacci sequence definition. F(N) = F(N-1) + F(N-2)
   *
   * @param n the number n to give to sequence Fn
   * @return the Fn sequence number (with n = 10 F(10) = 55)
   */
  private int recursive(final int n) {
    if (n == 0 || n == 1) {
      return n;
    }

    return recursive(n - 1) + recursive(n - 2);
  }

  /**
   * Iterative approach
   *
   * @param n the number n to give to sequence Fn
   * @return the Fn sequence number (with n = 10 F(10) = 55)
   */
  private int iterative(final int n) {
    validate(n);

    if (n == 0) {
      return 0;
    }

    if (n == 1 || n == 2) {
      return 1;
    }

    int previous = 1;
    int current = 1;
    int element = 0;
    for (int i = 2; i < n; i++) {
      element = previous + current;
      previous = current;
      current = element;
    }
    return element;
  }

  /**
   * Returns all the Fibonacci sequence numbers until Fn
   *
   * @return the Fibonacci sequence numbers Fn
   */
  public int[] getSequence() {
    int[] sequence = new int[n + 1];
    for (int i = 0; i < sequence.length; i++) {
      sequence[i] = recursive ? recursive(i) : iterative(i);
    }
    return sequence;
  }

  /**
   * Returns the Fibonacci sequence numbers lower or equal to n in a List
   *
   * @return the Fibonacci sequence numbers lower or equal to n in a List
   */
  public List<Integer> getSequenceLowerThanN() {
    List<Integer> sequence = new ArrayList<Integer>();

    int i = 1;
    int fib = 0;
    while (fib <= n) {
      sequence.add(fib);
      fib = recursive ? recursive(i) : iterative(i);
      i++;
    }
    return sequence;
  }

  /**
   * Validate the given number is not negative
   *
   * @param n the number n to give to sequence Fn
   */
  private void validate(final int n) {
    if (n < 0) {
      throw new IllegalArgumentException("Given number can't be negative!");
    }
  }
}
