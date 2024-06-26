package org.dsa.datastructure;

public interface Stack<T> {
    void push(T t);
    T pop();
    T peek();
    boolean isEmpty();
    boolean isFull();
}
