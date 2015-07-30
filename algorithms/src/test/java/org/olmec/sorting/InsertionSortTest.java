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
    new InsertionSort<Integer>().sort(null);
  }

  @Test
  public void testEmpty() {
    Integer[] array = new Integer[0];
    new InsertionSort<Integer>().sort(array);
    assertTrue("Insertion sort unsorted error. Result = " + print(array),
               new SortingValidator().isSorted(array));
  }

  @Test
  public void testSizeOne() {
    Integer[] array = {1};
    new InsertionSort<Integer>().sort(array);
    assertTrue("Insertion sort unsorted error. Result = " + print(array),
               new SortingValidator().isSorted(array));
  }

  @Test
  public void smallSizedRandomTest() {
    InsertionSort sort = new InsertionSort();

    Integer[] unsorted = createRandom(SIZE_LOW);
    sort.sort(unsorted);
    assertTrue("Insertion sort unsorted error. Result = " + print(unsorted),
               new SortingValidator().isSorted(unsorted));
  }

  @Test
  public void mediumSizedRandomTest() {
    InsertionSort sort = new InsertionSort();

    Integer[] unsorted = createRandom(SIZE_MEDIUM);
    sort.sort(unsorted);
    assertTrue("Insertion sort unsorted error. Result = " + print(unsorted),
               new SortingValidator().isSorted(unsorted));
  }

  @Test
  @Ignore("Takes too long!!!")
  public void bigSizedRandomTest() {
    InsertionSort sort = new InsertionSort();

    Integer[] unsorted = createRandom(SIZE_BIG);
    sort.sort(unsorted);
    assertTrue("Insertion sort unsorted error. Result = " + print(unsorted),
               new SortingValidator().isSorted(unsorted));
  }

  @Test
  public void smallSizedSortedTest() {
    InsertionSort sort = new InsertionSort();

    Integer[] sorted = createSorted(SIZE_LOW);
    sort.sort(sorted);
    assertTrue("Insertion sort unsorted error. Result = " + print(sorted),
               new SortingValidator().isSorted(sorted));
  }

  @Test
  public void mediumSizedSortedTest() {
    InsertionSort sort = new InsertionSort();

    Integer[] sorted = createSorted(SIZE_MEDIUM);
    sort.sort(sorted);
    assertTrue("Insertion sort unsorted error. Result = " + print(sorted),
               new SortingValidator().isSorted(sorted));
  }

  @Test
  public void bigSizedSortedTest() {
    InsertionSort sort = new InsertionSort();

    Integer[] sorted = createSorted(SIZE_BIG);
    sort.sort(sorted);
    assertTrue("Insertion sort unsorted error. Result = " + print(sorted),
               new SortingValidator().isSorted(sorted));
  }

  @Test
  public void smallSizedReversedTest() {
    InsertionSort sort = new InsertionSort();

    Integer[] reversed = createReversed(SIZE_LOW);
    sort.sort(reversed);
    assertTrue("Insertion sort unsorted error. Result = " + print(reversed),
               new SortingValidator().isSorted(reversed));
  }

  @Test
  public void mediumSizedReversedTest() {
    InsertionSort sort = new InsertionSort();

    Integer[] reversed = createReversed(SIZE_MEDIUM);
    sort.sort(reversed);
    assertTrue("Insertion sort unsorted error. Result = " + print(reversed),
               new SortingValidator().isSorted(reversed));
  }

  @Test
  @Ignore("Takes too long!!!")
  public void bigSizedReversedTest() {
    InsertionSort sort = new InsertionSort();

    Integer[] reversed = createReversed(SIZE_BIG);
    sort.sort(reversed);
    assertTrue("Insertion sort unsorted error. Result = " + print(reversed),
               new SortingValidator().isSorted(reversed));
  }
}
