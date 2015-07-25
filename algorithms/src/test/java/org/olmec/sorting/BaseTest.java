package org.olmec.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * @author t0tec (t0tec.olmec@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class BaseTest {
  protected final Random generator = new Random();
  protected final int MAX = 1000000;

  protected Integer[] createSorted(final int size) {
    Integer[] sorted = new Integer[size];

    for (int i = 0; i < sorted.length; i++) {
      sorted[i] = i;
    }

    return sorted;
  }

  protected Integer[] createReversed(final int size) {
    Integer[] reversed = createSorted(size);
    Arrays.sort(reversed, Collections.reverseOrder());

    print(reversed);

    return reversed;
  }

  protected Integer[] createRandom(final int size) {
    Integer[] random = new Integer[size];

    for (int i = 0; i < random.length; i++) {
      random[i] = generator.nextInt(MAX);
    }

    return random;
  }

  protected String print(final Object[] array) {
    return print(array, 0, array.length);
  }

  protected String print(final Object[] array, final int start, final int length) {
    final Object[] clone = array.clone();
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < length; i++) {
      Object e = clone[start + i];
      builder.append(e + " ");
    }
    return builder.toString();
  }
}
