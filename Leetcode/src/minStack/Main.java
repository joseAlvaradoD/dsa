package minStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    MinStack minStack = new MinStack();
}
class MinStack{
    Deque<Integer> stack;
    Deque<Integer> minStack;

    MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int value) {
        stack.push(value);
        if(minStack.isEmpty() || minStack.peek() >= value){
            minStack.push(value);
        }
    }

    public void pop() {
        int val = stack.pop();
        if(!minStack.isEmpty() && val == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.isEmpty()?0:minStack.peek();
    }
}
