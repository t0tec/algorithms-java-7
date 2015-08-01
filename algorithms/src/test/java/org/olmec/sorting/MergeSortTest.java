package org.olmec.sorting;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author t0tec (t0tec.olmec@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class MergeSortTest extends BaseTest {

  private static final int SIZE_LOW = 10;
  private static final int SIZE_MEDIUM = 10000;
  private static final int SIZE_BIG = 1000000;

  @Test
  @Ignore("Should I need to null check array?")
  public void testNull() {
    new BubbleSort().sort(null);
  }

  @Test
  public void testEmpty() {
    Integer[] array = new Integer[0];
    new MergeSort().sort(array);
    assertTrue("Merge sort unsorted error. Result = " + print(array),
               new SortingValidator().isSorted(array));
  }

  @Test
  public void testSizeOne() {
    Integer[] array = {1};
    new MergeSort().sort(array);
    assertTrue("Merge sort unsorted error. Result = " + print(array),
               new SortingValidator().isSorted(array));
  }

  @Test
  public void smallSizedRandomTest() {
    Integer[] unsorted = createRandom(SIZE_LOW);
    new MergeSort().sort(unsorted);
    assertTrue("Merge sort unsorted error. Result = " + print(unsorted),
               new SortingValidator().isSorted(unsorted));
  }

  @Test
  public void mediumSizedRandomTest() {
    Integer[] unsorted = createRandom(SIZE_MEDIUM);
    new MergeSort().sort(unsorted);
    assertTrue("Merge sort unsorted error. Result = " + print(unsorted),
               new SortingValidator().isSorted(unsorted));
  }

  @Test
  public void bigSizedRandomTest() {
    Integer[] unsorted = createRandom(SIZE_BIG);
    new MergeSort().sort(unsorted);
    assertTrue("Merge sort unsorted error. Result = " + print(unsorted),
               new SortingValidator().isSorted(unsorted));
  }

  @Test
  public void smallSizedSortedTest() {
    Integer[] sorted = createSorted(SIZE_LOW);
    new MergeSort().sort(sorted);
    assertTrue("Merge sort unsorted error. Result = " + print(sorted),
               new SortingValidator().isSorted(sorted));
  }

  @Test
  public void mediumSizedSortedTest() {
    Integer[] sorted = createSorted(SIZE_MEDIUM);
    new MergeSort().sort(sorted);
    assertTrue("Merge sort unsorted error. Result = " + print(sorted),
               new SortingValidator().isSorted(sorted));
  }

  @Test
  public void bigSizedSortedTest() {
    Integer[] sorted = createSorted(SIZE_BIG);
    new MergeSort().sort(sorted);
    assertTrue("Merge sort unsorted error. Result = " + print(sorted),
               new SortingValidator().isSorted(sorted));
  }

  @Test
  public void smallSizedReversedTest() {
    Integer[] reversed = createReversed(SIZE_LOW);
    new MergeSort().sort(reversed);
    assertTrue("Merge sort unsorted error. Result = " + print(reversed),
               new SortingValidator().isSorted(reversed));
  }

  @Test
  public void mediumSizedReversedTest() {
    Integer[] reversed = createReversed(SIZE_MEDIUM);
    new MergeSort().sort(reversed);
    assertTrue("Merge sort unsorted error. Result = " + print(reversed),
               new SortingValidator().isSorted(reversed));
  }

  @Test
  public void bigSizedReversedTest() {
    Integer[] reversed = createReversed(SIZE_BIG);
    new MergeSort().sort(reversed);
    assertTrue("Merge sort unsorted error. Result = " + print(reversed),
               new SortingValidator().isSorted(reversed));
  }
}
