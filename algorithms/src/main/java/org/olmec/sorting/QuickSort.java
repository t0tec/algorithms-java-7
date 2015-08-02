package org.olmec.sorting;

import java.util.Random;

/**
 * Quick sort is a divide-and-conquer method for sorting. It works by partitioning an array into two
 * parts, then sorting the parts independently
 *
 * Properties: Not stable - O(lg(n)) extra space (see discussion) - O(n2) time, but typically
 * O(n·lg(n)) time - Not adaptive
 *
 * Average case = O((n log(n))) Worst case = O(n²) Best case = O((n log(n))) Space Complexity: Worst
 * case = O(log(n))
 *
 * http://www.sorting-algorithms.com/quick-sort & http://en.wikipedia.org/wiki/Quick_sort
 *
 * @author t0tec (t0tec.olmec@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class QuickSort {

  private static Random random = new Random(System.currentTimeMillis());

  /**
   * Sort the array by using quick sort algorithm
   *
   * @param array the array
   */
  public <T extends Comparable<T>> void sort(T[] array) {
    /*
    Short answer: is needed for performance guarantee

    Sorting an already sorted array is worst case in quick sort,
    because whenever you pick a pivot, you discover that all
    the elements get placed on the same side of the pivot,
    so you don't split into two roughly equal halves at all.
    And often in practice this already sorted case will turn up more often than other cases.
     */
    shuffle(array);
    sort(array, 0, array.length - 1);
  }

  /**
   * Quick sort the sub array from array[low] to array[high]
   *
   * @param array the array
   * @param low   the lowest index
   * @param high  the highest index
   * @param <T>   the type of the objects
   */
  private <T extends Comparable<T>> void sort(T[] array, int low, int high) {
    if (high <= low) {
      return;
    }
    int j = partition(array, low, high);
    sort(array, low, j - 1);
    sort(array, j + 1, high);
  }

  /**
   * partition the sub array array[low..high] so that array[low..j - 1] <= array[j] <= array[j +
   * 1..high] and return the index j.
   *
   * @param array the sub array
   * @param low   the lowest index
   * @param high  the highest index
   * @param <T>   the type of the objects
   * @return index j
   */
  private <T extends Comparable<T>> int partition(T[] array, int low, int high) {
    int i = low;
    int j = high + 1;
    T v = array[low];
    while (true) {

      // find item on low to swap
      while (less(array[++i], v)) {
        if (i == high) {
          break;
        }
      }

      // find item on high to swap
      while (less(v, array[--j])) {
        if (j == low) {
          break;      // redundant since a[low] acts as sentinel
        }
      }

      // check if pointers cross
      if (i >= j) {
        break;
      }

      swap(array, i, j);
    }

    // put partitioning item v at a[j]
    swap(array, low, j);

    // now, a[low .. j-1] <= a[j] <= a[j+1 .. hi]
    return j;
  }

  /**
   * Swap array[i] and array[j]
   *
   * @param array the array
   * @param i     the index i
   * @param j     the index j
   * @param <T>   the type of the objects
   */
  private <T extends Comparable<T>> void swap(T[] array, int i, int j) {
    T swap = array[i];
    array[i] = array[j];
    array[j] = swap;
  }

  /**
   * is i less than j?
   *
   * @param i   object i
   * @param j   object j
   * @param <T> the type of the objects
   * @return true if i is less than j and otherwise false
   */
  private <T extends Comparable<T>> boolean less(T i, T j) {
    return i.compareTo(j) < 0;
  }

  /**
   * Rearrange the elements of an int array in random order.
   *
   * @param <T> the type of the objects
   */
  private <T extends Comparable<T>> void shuffle(T[] array) {
    int n = array.length;
    for (int i = 0; i < n; i++) {
      int r = i + uniform(n - i);     // between i and n - 1
      T temp = array[i];
      array[i] = array[r];
      array[r] = temp;
    }
  }

  /**
   * Returns an integer uniformly between 0 (inclusive) and n (exclusive).
   *
   * @param n   an integer n
   * @return a number between 0 and n - 1
   */
  private int uniform(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException("Parameter n must be positive!");
    }
    return random.nextInt(n);
  }
}
