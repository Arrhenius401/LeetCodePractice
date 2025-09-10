package Heap;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>((a,b)->(b-a));
        this.minHeap = new PriorityQueue<>((a,b)->(a-b));
    }

    public void addNum(int num) {
        int n = maxHeap.size();
        int m = minHeap.size();

        if((n+m) == 0){
            minHeap.offer(num);
            return;
        }


        if(num >= minHeap.peek()){
            if(n != m){
                int temp = minHeap.poll();
                maxHeap.offer(temp);
            }

            minHeap.offer(num);
        } else  {
            maxHeap.offer(num);
            if(n == m){
                int temp = maxHeap.poll();
                minHeap.offer(temp);
            }
        }
    }

    public double findMedian() {
        int n = maxHeap.size()+minHeap.size();

        if(n%2 == 0){
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }else {
            return minHeap.peek();
        }
    }
}
