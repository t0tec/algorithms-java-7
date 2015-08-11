package org.olmec.datastructures;

/**
 * @author t0tec (t0tec.olmec@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public interface Stack<T> {

  /**
   * Pushes an object onto the top of this stack
   *
   * @param object the object to be pushed onto this stack
   */
  void push(T object);

  /**
   * Removes the object at the top of this stack and returns that object as the value of this
   * function
   *
   * @return The object at the top of this stack
   */
  T pop();

  /**
   * Looks at the object at the top of this stack without removing it from the stack.
   *
   * @return The object at the top of this stack
   */
  T peek();

  /**
   * Checks if this stack is empty (its size is zero) or not
   *
   * @return true if the stack is empty and false otherwise
   */
  boolean isEmpty();

  /**
   * Returns the number of objects in this stack
   *
   * @return the number of objects in the stack
   */
  int size();

}
