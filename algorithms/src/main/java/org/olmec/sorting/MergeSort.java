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
   * Sort the array by using merge sort algorithm
   *
   * @param array the array
   */
  public <T extends Comparable<T>> void sort(T[] array) {
    T[] aux = (T[]) new Comparable[array.length];
    sort(array, aux, 0, array.length - 1);
    assert isSorted(array);
  }

  // stably merge a[low .. mid] with a[mid + 1 ..high] using aux[low .. high]
  private <T extends Comparable<T>> void merge(T[] a, T[] aux, int low, int mid, int high) {
    // precondition: a[low .. mid] and a[mid + 1 .. high] are sorted sub arrays
    assert isSorted(a, low, mid);
    assert isSorted(a, mid + 1, high);

    // copy to aux[]
    for (int k = low; k <= high; k++) {
      aux[k] = a[k];
    }

    // merge back to a[]
    int i = low, j = mid + 1;
    for (int k = low; k <= high; k++) {
      if (i > mid) {
        a[k] = aux[j++];   // this copying is unnecessary
      } else if (j > high) {
        a[k] = aux[i++];
      } else if (less(aux[j], aux[i])) {
        a[k] = aux[j++];
      } else {
        a[k] = aux[i++];
      }
    }

    // post condition: a[low .. high] is sorted
    assert isSorted(a, low, high);
  }

  // merge sort a[low..high] using auxiliary array aux[low..high]
  private <T extends Comparable<T>> void sort(T[] a, T[] aux, int low, int high) {
    if (high <= low) {
      return;
    }
    int mid = low + (high - low) / 2;
    sort(a, aux, low, mid);
    sort(a, aux, mid + 1, high);
    merge(a, aux, low, mid, high);
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
