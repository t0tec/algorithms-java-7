package org.olmec.datastructures;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author t0tec (t0tec.olmec@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class ArrayStackTest {

  @Test
  public void testNewStackIsEmpty() {
    ArrayStack<Integer> stack = new ArrayStack<Integer>();
    assertTrue(stack.isEmpty());
    assertEquals(stack.size(), 0);
  }

  @Test
  public void testPushThenPeek() {
    ArrayStack<Integer> stack = new ArrayStack<Integer>();
    stack.push(10);
    assertEquals(new Integer(10), stack.peek());
    assertEquals(1, stack.size());
  }

  @Test
  public void testPushThenPop() {
    ArrayStack<Integer> stack = new ArrayStack<Integer>();
    final Integer adding = new Integer(10);
    stack.push(adding);
    assertEquals(adding, stack.pop());
    assertEquals(0, stack.size());
  }

  @Test
  public void testPushesToEmptyStack() {
    ArrayStack<Integer> stack = new ArrayStack<Integer>();
    int numberOfPushes = 10;
    for (int i = 0; i < numberOfPushes; i++) {
      stack.push(i);
    }
    assertFalse(stack.isEmpty());
    assertEquals(stack.size(), numberOfPushes);
  }

  @Test
  public void testPoppingDownToEmptyStack() {
    ArrayStack<Integer> stack = new ArrayStack<Integer>();
    int numberOfPushes = (int) (Math.random() * 10 + 1);
    for (int i = 0; i < numberOfPushes; i++) {
      stack.push(i);
    }
    for (int i = 0; i < numberOfPushes; i++) {
      stack.pop();
    }
    assertTrue(stack.isEmpty());
    assertEquals(stack.size(), 0);
  }

  @Test
  @Ignore("http://stackoverflow.com/questions/14920164/how-to-junit-test-a-iterator")
  public void testIteratorStack() {
    ArrayStack<Integer> stack = new ArrayStack<Integer>();
    int numberOfPushes = (int) (Math.random() * 10 + 1);
    for (int i = 0; i < numberOfPushes; i++) {
      stack.push(i);
    }

    Iterator<Integer> itr = stack.iterator();
    assertTrue(itr.hasNext());
  }

  @Test(expected = NoSuchElementException.class)
  public void testPopOnEmptyStack() {
    new ArrayStack<Integer>().pop();
  }

  @Test(expected = NoSuchElementException.class)
  public void testPeekOnEmptyStack() {
    new ArrayStack<Integer>().peek();
  }
}
