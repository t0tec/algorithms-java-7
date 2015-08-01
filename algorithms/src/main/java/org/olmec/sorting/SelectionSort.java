package org.olmec.sorting;

/**
 * Selection sort. One of the simplest sorting algorithms works as follows: First, find the smallest
 * item in the array, and exchange it with the first entry. Then, find the next smallest item and
 * exchange it with the second entry. Continue in this way until the entire array is sorted. This
 * method is called selection sort because it works by repeatedly selecting the smallest remaining
 * item.
 *
 * Properties: - Not stable - O(1) extra space - Θ(n²) comparisons - Θ(n) swaps - Not adaptive
 *
 * Average case = O(n²) Worst case = O(n²) Best case = O(n²) Space Complexity: Worst case = O(1)
 *
 * http://www.sorting-algorithms.com/selection-sort & http://en.wikipedia.org/wiki/Selection_sort
 *
 * @author t0tec (t0tec.olmec@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class SelectionSort {

  /**
   * Sort the array by using selection sort algorithm
   *
   * @param array the array
   */
  public <T extends Comparable<T>> void sort(T[] array) {
    int n = array.length;
    for (int i = 0; i < n; i++) {
      int min = i;
      for (int j = i + 1; j < n; j++) {
        if (less(array[j], array[min])) {
          min = j;
        }
      }
      swap(array, min, i);
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
