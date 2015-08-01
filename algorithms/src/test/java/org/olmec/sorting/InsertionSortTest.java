package org.olmec.sorting;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author t0tec (t0tec.olmec@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class InsertionSortTest extends BaseTest {

  private static final int SIZE_LOW = 10;
  private static final int SIZE_MEDIUM = 10000;
  private static final int SIZE_BIG = 1000000;

  @Test
  @Ignore("Should I need to null check array?")
  public void testNull() {
    new InsertionSort().sort(null);
  }

  @Test
  public void testEmpty() {
    Integer[] array = new Integer[0];
    new InsertionSort().sort(array);
    assertTrue("Insertion sort unsorted error. Result = " + print(array),
               new SortingValidator().isSorted(array));
  }

  @Test
  public void testSizeOne() {
    Integer[] array = {1};
    new InsertionSort().sort(array);
    assertTrue("Insertion sort unsorted error. Result = " + print(array),
               new SortingValidator().isSorted(array));
  }

  @Test
  public void smallSizedRandomTest() {
    Integer[] unsorted = createRandom(SIZE_LOW);
    new InsertionSort().sort(unsorted);
    assertTrue("Insertion sort unsorted error. Result = " + print(unsorted),
               new SortingValidator().isSorted(unsorted));
  }

  @Test
  public void mediumSizedRandomTest() {
    Integer[] unsorted = createRandom(SIZE_MEDIUM);
    new InsertionSort().sort(unsorted);
    assertTrue("Insertion sort unsorted error. Result = " + print(unsorted),
               new SortingValidator().isSorted(unsorted));
  }

  @Test
  @Ignore("Takes too long!!!")
  public void bigSizedRandomTest() {
    Integer[] unsorted = createRandom(SIZE_BIG);
    new InsertionSort().sort(unsorted);
    assertTrue("Insertion sort unsorted error. Result = " + print(unsorted),
               new SortingValidator().isSorted(unsorted));
  }

  @Test
  public void smallSizedSortedTest() {
    Integer[] sorted = createSorted(SIZE_LOW);
    new InsertionSort().sort(sorted);
    assertTrue("Insertion sort unsorted error. Result = " + print(sorted),
               new SortingValidator().isSorted(sorted));
  }

  @Test
  public void mediumSizedSortedTest() {
    Integer[] sorted = createSorted(SIZE_MEDIUM);
    new InsertionSort().sort(sorted);
    assertTrue("Insertion sort unsorted error. Result = " + print(sorted),
               new SortingValidator().isSorted(sorted));
  }

  @Test
  public void bigSizedSortedTest() {
    Integer[] sorted = createSorted(SIZE_BIG);
    new InsertionSort().sort(sorted);
    assertTrue("Insertion sort unsorted error. Result = " + print(sorted),
               new SortingValidator().isSorted(sorted));
  }

  @Test
  public void smallSizedReversedTest() {
    Integer[] reversed = createReversed(SIZE_LOW);
    new InsertionSort().sort(reversed);
    assertTrue("Insertion sort unsorted error. Result = " + print(reversed),
               new SortingValidator().isSorted(reversed));
  }

  @Test
  public void mediumSizedReversedTest() {
    Integer[] reversed = createReversed(SIZE_MEDIUM);
    new InsertionSort().sort(reversed);
    assertTrue("Insertion sort unsorted error. Result = " + print(reversed),
               new SortingValidator().isSorted(reversed));
  }

  @Test
  @Ignore("Takes too long!!!")
  public void bigSizedReversedTest() {
    Integer[] reversed = createReversed(SIZE_BIG);
    new InsertionSort().sort(reversed);
    assertTrue("Insertion sort unsorted error. Result = " + print(reversed),
               new SortingValidator().isSorted(reversed));
  }
}
