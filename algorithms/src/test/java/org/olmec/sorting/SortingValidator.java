package org.olmec.sorting;

import java.util.Comparator;

/**
 * Validates if array is sorted
 *
 * @param <T> the type of the objects
 * @author t0tec (t0tec.olmec@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class SortingValidator {

  /**
   * is i < j ?
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
   * is i < j using a comparator
   *
   * @param c   the comparator specifying the order
   * @param i   object i
   * @param j   object j
   * @param <T> the type of the objects
   * @return true if i is less than j and otherwise false
   */
  private <T extends Comparable<T>> boolean less(Comparator<T> c, T i, T j) {
    return c.compare(i, j) < 0;
  }

  /***********************************************************************
   * Check if array is sorted - useful for debugging
   ***********************************************************************/

  /**
   * is the array a[] sorted?
   *
   * @param arr the array
   * @param <T> the type of the objects
   * @return true if the array is sorted and false otherwise
   */
  public <T extends Comparable<T>> boolean isSorted(T[] arr) {
    return this.isSorted(arr, 0, arr.length - 1);
  }

  /**
   * is the array sorted from a[low] to a[high]
   *
   * @param arr  the array
   * @param low  the low index
   * @param high the high index
   * @param <T>  the type of the objects
   * @return true if the array is sorted and false otherwise
   */
  public <T extends Comparable<T>> boolean isSorted(T[] arr, int low, int high) {
    for (int i = low + 1; i <= high; i++) {
      if (less(arr[i], arr[i - 1])) {
        return false;
      }
    }
    return true;
  }

  /**
   * is the array a[] sorted?
   *
   * @param arr the array
   * @param c   the comparator specifying the order
   * @param <T> the type of the objects
   * @return true if the array is sorted and false otherwise
   */
  public <T extends Comparable<T>> boolean isSorted(T[] arr, Comparator<T> c) {
    return this.isSorted(arr, c, 0, arr.length - 1);
  }

  /**
   * is the array sorted from a[low] to a[high]
   *
   * @param arr    the array
   * @param c    the comparator specifying the order
   * @param low  the low index
   * @param high the high index
   * @param <T>  the type of the objects
   * @return true if the array is sorted and false otherwise
   */
  public <T extends Comparable<T>> boolean isSorted(T[] arr, Comparator<T> c, int low, int high) {
    for (int i = low + 1; i <= high; i++) {
      if (less(c, arr[i], arr[i - 1])) {
        return false;
      }
    }
    return true;
  }
}
