package org.olmec.sorting;

/**
 * Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm that repeatedly
 * steps through the list to be sorted, compares each pair of adjacent items and swaps them if they
 * are in the wrong order. The pass through the list is repeated until no swaps are needed, which
 * indicates that the list is sorted. The algorithm, which is a comparison sort, is named for the
 * way smaller elements "bubble" to the top of the list. Although the algorithm is simple, it is too
 * slow and impractical for most problems even when compared to insertion sort. It can be practical
 * if the input is usually in sort order but may occasionally have some out-of-order elements nearly
 * in position.
 *
 * Properties: Stable - O(1) extra space - O(n²) comparisons and swaps - Adaptive: O(n) when nearly
 * sorted
 *
 * Average case = O(n²) Worst case = O(n²) Best case = O(n) - Space Complexity: Worst case = O(1)
 *
 * http://www.sorting-algorithms.com/bubble-sort & http://en.wikipedia.org/wiki/Bubble_sort
 *
 * @author t0tec (t0tec.olmec@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class BubbleSort<T extends Comparable<T>> {

  /**
   * Sort the array by using bubble sort algorithm.
   * Optimized so, the inner loop can avoid looking at
   * the last n-1 items (which are already sorted) when running for the n-th time
   *
   * @param array the array
   */
  public void sort(T[] array) {
    int n = array.length;
    boolean swapped = true;
    while (swapped) {
      swapped = false;
      for (int i = 1; i <= n - 1; i++) {
        if (less(array[i], array[i - 1])) {
          swap(array, i, i - 1);
          swapped = true;
        }
      }
      n--;
    }
  }

  /**
   * Swap a[i] and a[j]
   *
   * @param array the array
   * @param i     the index i
   * @param j     the index j
   */
  private void swap(Comparable<T>[] array, int i, int j) {
    Comparable<T> swap = array[i];
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

  public static void main(String[] args) {
    BubbleSort sort = new BubbleSort();

    Integer[] array = {5, 4, 3, 2, 1};

    sort.sort(array);

    for (Integer i : array) {
      System.out.println(i);
    }
  }
}
