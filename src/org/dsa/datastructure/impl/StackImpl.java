package org.dsa.datastructure.impl;

import org.dsa.datastructure.Stack;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StackImpl<T> implements Stack<T> {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Stack<Integer> stack = new StackImpl<>(1);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.push(3);
        stack.push(1);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }


    private Object[] array;
    private int topIndex = -1;

    public StackImpl (int size){
        this.array = new Object[size];
    }

    @Override
    public void push(T t) {
        if(isFull()){
            this.array = Arrays.copyOf(this.array, this.array.length*2);
        }
        this.array[this.topIndex +1] = t;
        this.topIndex++;
    }

    @Override
    public T pop() {
        if(!isEmpty()){
            T t = (T) this.array[this.topIndex];
            this.array[this.topIndex] = null;
            this.topIndex--;
            return t;
        }
        return null;
    }

    @Override
    public T peek() {
        if(!isEmpty()){
            return (T) this.array[this.topIndex];
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.topIndex < 0;
    }

    @Override
    public boolean isFull() {
        return this.topIndex >= this.array.length-1;
    }
}
