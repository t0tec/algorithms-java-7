package org.olmec.sorting;

/**
 * The algorithm that people often use to sort bridge hands is to consider the cards one at a time,
 * inserting each into its proper place among those already considered sorted (keeping them sorted).
 * In a computer implementation, we need to make space for the current item by moving larger items
 * one position to the right, before inserting the current item into the vacated position.
 *
 * Properties: Stable - O(1) extra space - O(n²) comparisons and swaps - Adaptive: O(n) time when
 * nearly sorted - Very low overhead
 *
 * Average case = O(n²) Worst case = O(n²) Best case = O(n) Space Complexity: Worst case = O(1)
 *
 * http://www.sorting-algorithms.com/insertion-sort & http://en.wikipedia.org/wiki/Insertion_sort
 *
 * @param <T> the type of objects to be sorted
 * @author t0tec (t0tec.olmec@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class InsertionSort {

  /**
   * Sort the array by using insertion sort algorithm
   *
   * @param array the array
   */
  public <T extends Comparable<T>> void sort(T[] array) {
    int n = array.length;
    for (int i = 0; i < n; i++) {
      int j = i;
      while (j > 0 && less(array[j], array[j - 1])) {
        swap(array, j, j - 1);
        j--;
      }
    }
  }

  /**
   * Sort the array by using insertion sort algorithm. This only performs one assignment in the
   * inner loop body.
   *
   * @param array the array
   */
  public <T extends Comparable<T>> void altSort(T[] array) {
    int n = array.length;
    for (int i = 0; i < n; i++) {
      T x = array[i];
      int j = i;
      while (j > 0 && less(x, array[j - 1])) {
        array[j] = array[j - 1];
        j--;
      }
      array[j] = x;
    }
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
}
