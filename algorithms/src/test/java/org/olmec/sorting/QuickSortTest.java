package org.olmec.sorting;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author t0tec (t0tec.olmec@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class QuickSortTest extends BaseTest {

  private static final int SIZE_LOW = 10;
  private static final int SIZE_MEDIUM = 10000;
  private static final int SIZE_BIG = 1000000;

  @Test
  @Ignore("Should I need to null check array?")
  public void testNull() {
    new QuickSort().sort(null);
  }

  @Test
  public void testEmpty() {
    Integer[] array = new Integer[0];
    new QuickSort().sort(array);
    assertTrue("Quick sort unsorted error. Result = " + print(array),
               new SortingValidator().isSorted(array));
  }

  @Test
  public void testSizeOne() {
    Integer[] array = {1};
    new QuickSort().sort(array);
    assertTrue("Quick sort unsorted error. Result = " + print(array),
               new SortingValidator().isSorted(array));
  }

  @Test
  public void smallSizedRandomTest() {
    Integer[] unsorted = createRandom(SIZE_LOW);
    new QuickSort().sort(unsorted);
    assertTrue("Quick sort unsorted error. Result = " + print(unsorted),
               new SortingValidator().isSorted(unsorted));
  }

  @Test
  public void mediumSizedRandomTest() {
    Integer[] unsorted = createRandom(SIZE_MEDIUM);
    new QuickSort().sort(unsorted);
    assertTrue("Quick sort unsorted error. Result = " + print(unsorted),
               new SortingValidator().isSorted(unsorted));
  }

  @Test
  public void bigSizedRandomTest() {
    Integer[] unsorted = createRandom(SIZE_BIG);
    new QuickSort().sort(unsorted);
    assertTrue("Quick sort unsorted error. Result = " + print(unsorted),
               new SortingValidator().isSorted(unsorted));
  }

  @Test
  public void smallSizedSortedTest() {
    Integer[] sorted = createSorted(SIZE_LOW);
    new QuickSort().sort(sorted);
    assertTrue("Quick sort unsorted error. Result = " + print(sorted),
               new SortingValidator().isSorted(sorted));
  }

  @Test
  public void mediumSizedSortedTest() {
    Integer[] sorted = createSorted(SIZE_MEDIUM);
    new QuickSort().sort(sorted);
    assertTrue("Quick sort unsorted error. Result = " + print(sorted),
               new SortingValidator().isSorted(sorted));
  }

  @Test
  public void bigSizedSortedTest() {
    Integer[] sorted = createSorted(SIZE_BIG);
    new QuickSort().sort(sorted);
    assertTrue("Quick sort unsorted error. Result = " + print(sorted),
               new SortingValidator().isSorted(sorted));
  }

  @Test
  public void smallSizedReversedTest() {
    Integer[] reversed = createReversed(SIZE_LOW);
    new QuickSort().sort(reversed);
    assertTrue("Quick sort unsorted error. Result = " + print(reversed),
               new SortingValidator().isSorted(reversed));
  }

  @Test
  public void mediumSizedReversedTest() {
    Integer[] reversed = createReversed(SIZE_MEDIUM);
    new QuickSort().sort(reversed);
    assertTrue("Quick sort unsorted error. Result = " + print(reversed),
               new SortingValidator().isSorted(reversed));
  }

  @Test
  public void bigSizedReversedTest() {
    Integer[] reversed = createReversed(SIZE_BIG);
    new QuickSort().sort(reversed);
    assertTrue("Quick sort unsorted error. Result = " + print(reversed),
               new SortingValidator().isSorted(reversed));
  }
}
