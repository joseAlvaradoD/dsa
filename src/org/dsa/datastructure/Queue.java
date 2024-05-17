package org.dsa.datastructure;

public interface Queue <T>{
    // (Insert): Adds an element to the rear of the queue.
    void enqueue(T t);
    //(Delete): Removes and returns the element from the front of the queue.
    T dequeue();
    //Returns the element at the front of the queue without removing it.
    T peek();
    //Checks if the queue is empty.
    boolean isEmpty();
    //Checks if the queue is full.
    boolean isFull();
}
