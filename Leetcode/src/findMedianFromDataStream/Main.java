package findMedianFromDataStream;

import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
}

class MedianFinder {

    private PriorityQueue<Integer> largeHeap; //min heap
    private PriorityQueue<Integer> smallHeap;//max heap

    public MedianFinder() {
        largeHeap = new PriorityQueue<>();
        smallHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if(!largeHeap.isEmpty() && largeHeap.peek() < num){
            smallHeap.add(num);
        }else{
            largeHeap.add(num);
        }

        if(largeHeap.size()-smallHeap.size() > 1){
            smallHeap.add(largeHeap.poll());
        }
        if(smallHeap.size()-largeHeap.size() > 1){
            largeHeap.add(smallHeap.poll());
        }
    }

    public double findMedian() {
        if(smallHeap.size() == largeHeap.size() && !smallHeap.isEmpty()){
            return (smallHeap.peek() + largeHeap.peek())/2.0;
        }
        if(smallHeap.size() > largeHeap.size()){
            return (double) smallHeap.peek();
        }
        if(largeHeap.size() > smallHeap.size()){
            return (double) largeHeap.peek();
        }
        return 0.0;
    }
}
