package leet_code.Problem_703_Easy_Kth_Largest_Element_in_a_Stream;

import java.util.PriorityQueue;

public class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    /**
     * Initializes the object with k and the stream of integers.
     * Strategy: Use a Min-Heap of size k.
     * Time: O(N log k), Space: O(k).
     */
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    /**
     * Appends val and returns the kth largest element.
     * Strategy: Maintain heap size at k. The root will be the kth largest.
     */
    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll(); // Remove smallest to keep only top k
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargest kl = new KthLargest(3, new int[] { 4, 5, 8, 2 });
        System.out.println(kl.add(3)); // 4
        System.out.println(kl.add(5)); // 5
        System.out.println(kl.add(10)); // 5
        System.out.println(kl.add(9)); // 8
        System.out.println(kl.add(4)); // 8
    }
}
