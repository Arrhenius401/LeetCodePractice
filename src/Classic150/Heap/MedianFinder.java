package Classic150.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class MedianFinder {
    PriorityQueue<Integer> pqMax;
    PriorityQueue<Integer> pqMin;

    public MedianFinder() {
        pqMax = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        pqMin = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
    }

    public void addNum(int num) {
        if(pqMin.isEmpty() || num <= pqMin.peek()){
            pqMin.offer(num);
            if(pqMax.size() + 1 < pqMin.size()){
                pqMax.offer(pqMin.poll());
            }
        } else {
            pqMax.offer(num);
            if(pqMax.size() > pqMin.size()) {
                pqMin.offer(pqMax.poll());
            }
        }
    }

    public double findMedian() {
        if(pqMin.size() > pqMax.size()){
            return pqMin.peek();
        }

        return (pqMin.peek() + pqMax.peek()) / 2.0;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
    }
}
