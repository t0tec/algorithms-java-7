package org.olmec.datastructures;

/**
 * http://en.wikipedia.org/wiki/Stack_(abstract_data_type) & https://en.wikipedia.org/wiki/Linked_list#Singly_linked_lists
 *
 * @author t0tec (t0tec.olmec@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class LinkedListStack<T> implements Stack<T> {

  @Override
  public void push(T object) {
    throw new UnsupportedOperationException("#push()");
  }

  @Override
  public T pop() {
    throw new UnsupportedOperationException("#pop()");
  }

  @Override
  public T peek() {
    throw new UnsupportedOperationException("#peek()");
  }

  @Override
  public boolean isEmpty() {
    throw new UnsupportedOperationException("#isEmpty()");
  }

  @Override
  public int size() {
    throw new UnsupportedOperationException("#size()");
  }
}
