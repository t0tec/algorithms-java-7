package org.olmec.datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The (resizing) ArrayStack class represents a last-in-first-out (LIFO) stack of generic items. It
 * supports the usual push and pop operations, along with methods for peeking at the top item,
 * testing if the stack is empty, and iterating through the items in LIFO order. This implementation
 * uses a resizing array, which double the underlying array when it is full and halves the
 * underlying array when it is one-quarter full. The push and pop operations take constant amortized
 * time. The size, peek, and is-empty operations takes constant time in the worst case.
 *
 * http://en.wikipedia.org/wiki/Stack_(abstract_data_type) & http://en.wikipedia.org/wiki/Dynamic_array
 *
 * @author t0tec (t0tec.olmec@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class ArrayStack<T> implements Stack<T>, Iterable<T> {

  private T[] array;
  private int size;

  /**
   * Create an empty stack with initial length of 2 (size is empty)
   */
  public ArrayStack() {
    array = (T[]) new Object[2];
    size = 0;
  }

  @Override
  public void push(final T object) {
    // Increase size only if size is full (equals array.length)
    if (size == array.length) {
      resize(array.length * 2);
    }

    array[size++] = object;
  }

  @Override
  public T pop() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack underflow");
    }

    T object = array[--size];
    array[size] = null; // to avoid loitering

    // Shrink size only if size is 1/4 of length and size is bigger than zero
    if (size > 0 && size == array.length / 4) {
      resize(array.length / 2);
    }
    return object;
  }

  @Override
  public T peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack underflow");
    }

    return array[size - 1];
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public int size() {
    return size;
  }

  /**
   * Resize the array holding the objects
   *
   * @param capacity the new capacity of the array
   */
  private void resize(final int capacity) {
    T[] temp = (T[]) new Object[capacity];

    for (int i = 0; i < size; i++) {
      temp[i] = array[i];
    }

    array = temp;
  }

  /**
   * Returns an iterator to this stack that iterates through the items in LIFO order.
   *
   * @return an iterator to this stack that iterates through the items in LIFO order.
   */
  @Override
  public Iterator<T> iterator() {
    return new ReverseArrayIterator();
  }

  /**
   * A LIFO iterator, doesn't implement remove() since it's optional
   */
  private class ReverseArrayIterator implements Iterator<T> {

    private int i;

    /**
     * Default constructor setting i to the last index in the array stack (the object who was added
     * most recently
     */
    public ReverseArrayIterator() {
      i = size - 1;
    }

    /**
     * true if there is a next object in the array stack
     *
     * @return true if there is a next item on
     */
    public boolean hasNext() {
      return i >= 0;
    }

    /**
     * Not supported operation in the iterator
     */
    public void remove() {
      throw new UnsupportedOperationException();
    }

    /**
     * Returns the item most recently added, then the next till there's no next object left
     *
     * @return the most recently added object
     */
    public T next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      return array[i--];
    }
  }
}
