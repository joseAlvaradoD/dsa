package maximumFrequencyStack;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5); // The stack is [5]
        freqStack.push(7); // The stack is [5,7]
        freqStack.push(5); // The stack is [5,7,5]
        freqStack.push(7); // The stack is [5,7,5,7]
        freqStack.push(4); // The stack is [5,7,5,7,4]
        freqStack.push(5); // The stack is [5,7,5,7,4,5]
        freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
        freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
        freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
        freqStack.pop();
    }
}

class FreqStack {
    private Map<Integer, Integer> numberFreq = new HashMap<>();
    private Map<Integer, Deque<Integer>> freqNumberStack = new HashMap<>();
    private int maxFreq = 0;
    public FreqStack() {
    }

    public void push(int val) {
        int freq = numberFreq.getOrDefault(val, 0) + 1;
        numberFreq.put(val, freq);

        maxFreq = maxFreq<freq?freq:maxFreq;


        freqNumberStack.computeIfAbsent(freq,k -> new ArrayDeque<>()).push(val);
    }

    public int pop() {
        int val = freqNumberStack.get(maxFreq).pop();

        numberFreq.put(val, numberFreq.get(val) - 1);

        if(freqNumberStack.get(maxFreq).isEmpty()){
            maxFreq--;
        }

        return val;
    }
}
