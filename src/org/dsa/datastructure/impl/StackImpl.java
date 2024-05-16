package org.dsa.datastructure.impl;

import org.dsa.datastructure.Stack;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StackImpl<T> implements Stack<T> {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Stack<Integer> stack = new StackImpl<>(Integer.class,1);

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


    private T[] array;
    private int idx = -1;

    public StackImpl (Class<T> c, int size){
        this.array = (T[]) Array.newInstance(c, size);
    }

    @Override
    public void push(T t) {
        if(isFull()){
            this.array = Arrays.copyOf(this.array, this.array.length*2);
        }
        this.array[this.idx+1] = t;
        this.idx++;
    }

    @Override
    public T pop() {
        if(!isEmpty()){
            T t = this.array[this.idx];
            this.array[this.idx] = null;
            this.idx--;
            return t;
        }
        return null;
    }

    @Override
    public T peek() {
        if(!isEmpty()){
            return this.array[this.idx];
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.idx < 0;
    }

    @Override
    public boolean isFull() {
        return this.idx >= this.array.length-1;
    }
}
