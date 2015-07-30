package org.olmec.sorting;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author t0tec (t0tec.olmec@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class ShellSortTest extends BaseTest {

  private static final int SIZE_LOW = 10;
  private static final int SIZE_MEDIUM = 10000;
  private static final int SIZE_BIG = 1000000;

  @Test
  @Ignore("Should I need to null check array?")
  public void testNull() {
    new ShellSort<Integer>().sort(null);
  }

  @Test
  public void testEmpty() {
    Integer[] array = new Integer[0];
    new ShellSort<Integer>().sort(array);
    assertTrue("Shell sort unsorted error. Result = " + print(array),
               new SortingValidator().isSorted(array));
  }

  @Test
  public void testSizeOne() {
    Integer[] array = {1};
    new ShellSort<Integer>().sort(array);
    assertTrue("Shell sort unsorted error. Result = " + print(array),
               new SortingValidator().isSorted(array));
  }

  @Test
  public void smallSizedRandomTest() {
    ShellSort sort = new ShellSort();

    Integer[] unsorted = createRandom(SIZE_LOW);
    sort.sort(unsorted);
    assertTrue("Shell sort unsorted error. Result = " + print(unsorted),
               new SortingValidator().isSorted(unsorted));
  }

  @Test
  public void mediumSizedRandomTest() {
    ShellSort sort = new ShellSort();

    Integer[] unsorted = createRandom(SIZE_MEDIUM);
    sort.sort(unsorted);
    assertTrue("Shell sort unsorted error. Result = " + print(unsorted),
               new SortingValidator().isSorted(unsorted));
  }

  @Test
  public void bigSizedRandomTest() {
    ShellSort sort = new ShellSort();

    Integer[] unsorted = createRandom(SIZE_BIG);
    sort.sort(unsorted);
    assertTrue("Shell sort unsorted error. Result = " + print(unsorted),
               new SortingValidator().isSorted(unsorted));
  }

  @Test
  public void smallSizedSortedTest() {
    ShellSort sort = new ShellSort();

    Integer[] sorted = createSorted(SIZE_LOW);
    sort.sort(sorted);
    assertTrue("Shell sort unsorted error. Result = " + print(sorted),
               new SortingValidator().isSorted(sorted));
  }

  @Test
  public void mediumSizedSortedTest() {
    ShellSort sort = new ShellSort();

    Integer[] sorted = createSorted(SIZE_MEDIUM);
    sort.sort(sorted);
    assertTrue("Shell sort unsorted error. Result = " + print(sorted),
               new SortingValidator().isSorted(sorted));
  }

  @Test
  public void bigSizedSortedTest() {
    ShellSort sort = new ShellSort();

    Integer[] sorted = createSorted(SIZE_BIG);
    sort.sort(sorted);
    assertTrue("Shell sort unsorted error. Result = " + print(sorted),
               new SortingValidator().isSorted(sorted));
  }

  @Test
  public void smallSizedReversedTest() {
    ShellSort sort = new ShellSort();

    Integer[] reversed = createReversed(SIZE_LOW);
    sort.sort(reversed);
    assertTrue("Shell sort unsorted error. Result = " + print(reversed),
               new SortingValidator().isSorted(reversed));
  }

  @Test
  public void mediumSizedReversedTest() {
    ShellSort sort = new ShellSort();

    Integer[] reversed = createReversed(SIZE_MEDIUM);
    sort.sort(reversed);
    assertTrue("Shell sort unsorted error. Result = " + print(reversed),
               new SortingValidator().isSorted(reversed));
  }

  @Test
  public void bigSizedReversedTest() {
    ShellSort sort = new ShellSort();

    Integer[] reversed = createReversed(SIZE_BIG);
    sort.sort(reversed);
    assertTrue("Shell sort unsorted error. Result = " + print(reversed),
               new SortingValidator().isSorted(reversed));
  }
}
