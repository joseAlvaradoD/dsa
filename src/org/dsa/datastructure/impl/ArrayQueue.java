package org.dsa.datastructure.impl;

import org.dsa.datastructure.Queue;

import java.util.Arrays;

public class ArrayQueue<T> implements Queue<T> {

    public static void main(String[] args){
        Queue<Integer> queue = new ArrayQueue<>(4);

        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());

        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());
    }

    private Object[] array;
    private int rear = -1;
    private final int front = 0;

    public ArrayQueue(){
        this(10);
    }

    public ArrayQueue(int initSize){
        this.array = new Object[initSize];
    }

    @Override
    public void enqueue(T t) {
        if(isFull()){
            this.array = Arrays.copyOf(this.array, this.array.length*2);
        }
        this.array[this.rear + 1] = t;
        this.rear++;
    }

    @Override
    public T dequeue() {
        if(!isEmpty()){
            T t = (T) this.array[this.front];
            for(int i = 0; i < this.rear; i++){
                this.array[i] = this.array[i+1];
            }
            this.array[this.rear] = null;
            this.rear--;
            return t;
        }
        return null;
    }

    @Override
    public T peek() {
        if(!isEmpty()) {
            T t = (T) this.array[this.front];
            return t;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.rear+1 == this.front;
    }

    @Override
    public boolean isFull() {
        return this.rear + 1 >= this.array.length;
    }
}
