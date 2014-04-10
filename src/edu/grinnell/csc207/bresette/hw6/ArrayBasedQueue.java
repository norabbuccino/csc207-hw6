package edu.grinnell.csc207.bresette.hw6;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Queues implemented with arrays.
 *
 * @author Samuel A. Rebelsky
 * @author Nora Bresette Buccino
 * 
 * Got the idea to use modulo for put and get from 
 * http://www.careercup.com/question?id=14133666
 * 
 */
public class ArrayBasedQueue<T>
    implements Queue<T>
{
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The values stored in the queue.
   */
  T[] values;

  /**
   * The index of the front of the queue.  
   */
  int front;

  /**
   * The index of the end of the queue
   */
  int back;

  /**
   * The number of elements in the queue.
   */
  int size;

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new queue that holds up to capacity elements.
   */
  @SuppressWarnings({ "unchecked" })
  // Handle array casting
  public ArrayBasedQueue(int capacity) throws Exception
  {
    if (capacity <= 0)
      {
        throw new Exception("Queues must have a positive capacity.");
      } // if (capacity <= 0)
    // Yay Java!  It's not possible to say new T[capacity], so
    // we use this hack.
    this.values = (T[]) new Object[capacity];
    this.front = 0;
    this.back = 0;
    this.size = 0;
  } // ArayBasedQueue(int capacity)

  // +---------------+---------------------------------------------------
  // | Queue Methods |
  // +---------------+

  @Override
  public boolean isEmpty()
  {
    return (this.size == 0);
  } // isEmpty()

  @Override
  public boolean isFull()
  {
    return (this.back >= this.values.length && this.front == 0);
  } // isFull()

  @Override
  public void put(T val)
    throws Exception
  {
    if (this.isFull())
      {
        throw new Exception("no more room!");
      } // if(this.isFull())
    this.values[this.back] = val;
    this.back = (this.back + 1) % this.values.length;
    this.size++;

  } // put(T)

  @Override
  public T get()
    throws Exception
  {
    if (this.isEmpty())
      {
        throw new Exception("empty");
      } // if(this.isEmpty())
    T result = this.values[this.front];
    this.values[this.front] = null;
    this.front = (this.front + 1) % this.values.length;
    this.size--;
    return result;

  } // get(T)

  @Override
  public T peek()
    throws Exception
  {
    if (this.isEmpty())
      {
        throw new Exception("empty");
      } // if empty
    return this.values[this.front];
  } // peek()

  @Override
  public T dequeue()
    throws Exception
  {
    return this.get();
  } // dequeue

  @Override
  public void enqueue(T val)
    throws Exception
  {
    this.put(val);
  } // enqueue

  @Override
  public Iterator<T> iterator()
  {
    return new ArrayBasedQueueIterator<T>(this);
  } // iterator()
} // class ArrayBasedQueue<T>

class ArrayBasedQueueIterator<T>
    implements Iterator<T>
{
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+
  
  /**
   * The queue the iterator is iterating
   */
  ArrayBasedQueue<T> queue;
  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new iterator.
   */
  public ArrayBasedQueueIterator(ArrayBasedQueue<T> q)
  {
    this.queue = q;
  } // ArrayBasedQueueIterator

  // +---------+---------------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public T next()
    throws NoSuchElementException
  {
    if (!this.hasNext())
      {
        throw new NoSuchElementException("no elements remain");
      } // if no elements 
    return this.queue.values[this.queue.front];
  } // next()

  @Override
  public boolean hasNext()
  {
    return !this.queue.isEmpty();
  } // hasNext()

  @Override
  public void remove()
    throws UnsupportedOperationException
  {
    throw new UnsupportedOperationException();
  } // remove()
} // ArrayBasedQueueIterator<T>
