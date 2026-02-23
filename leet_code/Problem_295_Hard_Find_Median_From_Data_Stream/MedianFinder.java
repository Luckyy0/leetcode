package leet_code.Problem_295_Hard_Find_Median_From_Data_Stream;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    // Helper Queue to store smaller half of numbers. Max Heap.
    // Hàng đợi trợ giúp để lưu nửa nhỏ hơn của các số. Max Heap.
    private PriorityQueue<Integer> lowerHalf;

    // Helper Queue to store larger half of numbers. Min Heap.
    // Hàng đợi trợ giúp để lưu nửa lớn hơn của các số. Min Heap.
    private PriorityQueue<Integer> upperHalf;

    /**
     * Initializes the MedianFinder object.
     * Uses two Heaps pattern.
     * Time: O(1) init, O(log N) add, O(1) find. Space: O(N).
     * 
     * Khởi tạo đối tượng MedianFinder.
     * Sử dụng mẫu Hai Heap.
     */
    public MedianFinder() {
        // Max Heap (reverse order)
        lowerHalf = new PriorityQueue<>(Collections.reverseOrder());
        // Min Heap (natural order)
        upperHalf = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Step 1: Add to Max Heap
        lowerHalf.offer(num);

        // Step 2: Balance the contents (ensure sorting)
        // Move the largest element from lowerHalf to upperHalf
        upperHalf.offer(lowerHalf.poll());

        // Step 3: Balance the sizes
        // We want lowerHalf to have size N or N+1, upperHalf to have size N.
        if (lowerHalf.size() < upperHalf.size()) {
            lowerHalf.offer(upperHalf.poll());
        }
    }

    public double findMedian() {
        if (lowerHalf.size() > upperHalf.size()) {
            return lowerHalf.peek();
        } else {
            return (lowerHalf.peek() + upperHalf.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println("Median 1: " + medianFinder.findMedian()); // 1.5

        medianFinder.addNum(3);
        System.out.println("Median 2: " + medianFinder.findMedian()); // 2.0
    }
}
