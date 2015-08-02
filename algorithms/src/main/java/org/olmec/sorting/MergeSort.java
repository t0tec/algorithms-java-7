package org.olmec.sorting;

/**
 * Merging: combining two ordered arrays to make one larger ordered array. This operation
 * immediately lends itself to a simple recursive sort method known as mergesort: to sort an array,
 * divide it into two halves, sort the two halves (recursively), and then merge the results.
 *
 * Merge sort takes advantage of the ease of merging already sorted lists into a new sorted list. It
 * starts by comparing every two elements (i.e., 1 with 2, then 3 with 4...) and swapping them if
 * the first should come after the second. It then merges each of the resulting lists of two into
 * lists of four, then merges those lists of four, and so on; until at last two lists are merged
 * into the final sorted list. Of the algorithms described here, this is the first that scales well
 * to very large lists
 *
 * Properties: Stable - Θ(n) extra space for arrays (as shown) - Θ(lg(n)) extra space for linked
 * lists - Θ(n·lg(n)) time - Not adaptive Does not require random access to data
 *
 * Average case = O((n log(n))) Worst case = O((n log(n))) Best case = O((n log(n))) Space
 * Complexity: Worst case = O(n)
 *
 * http://www.sorting-algorithms.com/merge-sort & http://en.wikipedia.org/wiki/Merge_sort
 *
 * @author t0tec (t0tec.olmec@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class MergeSort {

  /**
   * Sort the array by using merge sort algorithm (top-down merge sort)
   *
   * @param array the array
   * @param <T>   the type of the objects
   */
  public <T extends Comparable<T>> void sort(T[] array) {
    T[] aux = (T[]) new Comparable[array.length];
    sort(array, aux, 0, array.length - 1);
    assert isSorted(array);
  }

  /**
   * stably merge array[low .. mid] with array[mid + 1 ..high] using aux[low .. high]
   *
   * @param array the array
   * @param aux   the auxiliary array
   * @param low   the lowest index
   * @param mid   the index in the middle
   * @param high  the highest index
   * @param <T>   the type of the objects
   */
  private <T extends Comparable<T>> void merge(T[] array, T[] aux, int low, int mid, int high) {
    // precondition: a[low .. mid] and a[mid + 1 .. high] are sorted sub arrays
    assert isSorted(array, low, mid);
    assert isSorted(array, mid + 1, high);

    // copy to aux[]
    for (int k = low; k <= high; k++) {
      aux[k] = array[k];
    }

    // merge back to array[]
    int i = low, j = mid + 1;
    for (int k = low; k <= high; k++) {
      if (i > mid) {
        array[k] = aux[j++];   // this copying is unnecessary
      } else if (j > high) {
        array[k] = aux[i++];
      } else if (less(aux[j], aux[i])) {
        array[k] = aux[j++];
      } else {
        array[k] = aux[i++];
      }
    }

    // post condition: array[low .. high] is sorted
    assert isSorted(array, low, high);
  }

  /**
   * merge sort array[low..high] using auxiliary array aux[low..high]
   *
   * @param array the original array
   * @param aux   auxiliary array
   * @param low   aux[low]
   * @param high  aux[high]
   * @param <T>   the type of the objects
   */
  private <T extends Comparable<T>> void sort(T[] array, T[] aux, int low, int high) {
    if (high <= low) {
      return;
    }
    int mid = low + (high - low) / 2;
    sort(array, aux, low, mid);
    sort(array, aux, mid + 1, high);
    merge(array, aux, low, mid, high);
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
   * Check if array is sorted
   *
   * @param array the given array
   * @param <T>   the type of the objects
   * @return true if array is sorted and otherwise false
   */
  private <T extends Comparable<T>> boolean isSorted(T[] array) {
    return isSorted(array, 0, array.length - 1);
  }

  /**
   * Check if array is sorted
   *
   * @param array the given array
   * @param low   the lowest index to start check from
   * @param high  the highest index to start check to (inclusive)
   * @param <T>   the type of the objects
   * @return true if array is sorted and otherwise false
   */
  private <T extends Comparable<T>> boolean isSorted(T[] array, int low, int high) {
    for (int i = low + 1; i <= high; i++) {
      if (less(array[i], array[i - 1])) {
        return false;
      }
    }
    return true;
  }
}
