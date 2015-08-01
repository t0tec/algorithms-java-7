package org.olmec.sorting;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author t0tec (t0tec.olmec@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class BubbleSortTest extends BaseTest {

  private static final int SIZE_LOW = 10;
  private static final int SIZE_MEDIUM = 10000;
  private static final int SIZE_BIG = 1000000;

  @Test
  @Ignore("Should I need to null check array?")
  public void testNull() {
    new BubbleSort<Integer>().sort(null);
  }

  @Test
  public void testEmpty() {
    Integer[] array = new Integer[0];
    new BubbleSort<Integer>().sort(array);
    assertTrue("Bubble sort unsorted error. Result = " + print(array),
               new SortingValidator().isSorted(array));
  }

  @Test
  public void testSizeOne() {
    Integer[] array = {1};
    new BubbleSort<Integer>().sort(array);
    assertTrue("Bubble sort unsorted error. Result = " + print(array),
               new SortingValidator().isSorted(array));
  }

  @Test
  public void smallSizedRandomTest() {
    BubbleSort sort = new BubbleSort();

    Integer[] unsorted = createRandom(SIZE_LOW);
    sort.sort(unsorted);
    assertTrue("Bubble sort unsorted error. Result = " + print(unsorted),
               new SortingValidator().isSorted(unsorted));
  }

  @Test
  public void mediumSizedRandomTest() {
    BubbleSort sort = new BubbleSort();

    Integer[] unsorted = createRandom(SIZE_MEDIUM);
    sort.sort(unsorted);
    assertTrue("Bubble sort unsorted error. Result = " + print(unsorted),
               new SortingValidator().isSorted(unsorted));
  }

  @Test
  @Ignore("Takes too long!!!")
  public void bigSizedRandomTest() {
    BubbleSort sort = new BubbleSort();

    Integer[] unsorted = createRandom(SIZE_BIG);
    sort.sort(unsorted);
    assertTrue("Bubble sort unsorted error. Result = " + print(unsorted),
               new SortingValidator().isSorted(unsorted));
  }

  @Test
  public void smallSizedSortedTest() {
    BubbleSort sort = new BubbleSort();

    Integer[] sorted = createSorted(SIZE_LOW);
    sort.sort(sorted);
    assertTrue("Bubble sort unsorted error. Result = " + print(sorted),
               new SortingValidator().isSorted(sorted));
  }

  @Test
  public void mediumSizedSortedTest() {
    BubbleSort sort = new BubbleSort();

    Integer[] sorted = createSorted(SIZE_MEDIUM);
    sort.sort(sorted);
    assertTrue("Bubble sort unsorted error. Result = " + print(sorted),
               new SortingValidator().isSorted(sorted));
  }

  @Test
  public void bigSizedSortedTest() {
    BubbleSort sort = new BubbleSort();

    Integer[] sorted = createSorted(SIZE_BIG);
    sort.sort(sorted);
    assertTrue("Bubble sort unsorted error. Result = " + print(sorted),
               new SortingValidator().isSorted(sorted));
  }

  @Test
  public void smallSizedReversedTest() {
    BubbleSort sort = new BubbleSort();

    Integer[] reversed = createReversed(SIZE_LOW);
    sort.sort(reversed);
    assertTrue("Bubble sort unsorted error. Result = " + print(reversed),
               new SortingValidator().isSorted(reversed));
  }

  @Test
  public void mediumSizedReversedTest() {
    BubbleSort sort = new BubbleSort();

    Integer[] reversed = createReversed(SIZE_MEDIUM);
    sort.sort(reversed);
    assertTrue("Bubble sort unsorted error. Result = " + print(reversed),
               new SortingValidator().isSorted(reversed));
  }

  @Test
  @Ignore("Takes too long!!!")
  public void bigSizedReversedTest() {
    BubbleSort sort = new BubbleSort();

    Integer[] reversed = createReversed(SIZE_BIG);
    sort.sort(reversed);
    assertTrue("Bubble sort unsorted error. Result = " + print(reversed),
               new SortingValidator().isSorted(reversed));
  }
}
