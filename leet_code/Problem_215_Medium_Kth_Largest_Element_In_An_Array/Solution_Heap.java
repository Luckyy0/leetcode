package leet_code.Problem_215_Medium_Kth_Largest_Element_In_An_Array;

import java.util.PriorityQueue;

public class Solution_Heap {

    /**
     * Finds the kth largest element in an array.
     * Uses a Min-Heap of size k to separate the top k elements.
     * Time: O(N log K), Space: O(K).
     * 
     * Tìm phần tử lớn thứ k trong mảng.
     * Sử dụng Min-Heap kích thước k để tách ra k phần tử hàng đầu.
     */
    public int findKthLargest(int[] nums, int k) {
        // Min-Heap to store the k largest elements seen so far
        // Min-Heap để lưu trữ k phần tử lớn nhất đã thấy
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);

            // If heap size exceeds k, remove the smallest element from the heap
            // ensure the heap only holds the k largest elements
            // Nếu kích thước heap vượt quá k, loại bỏ phần tử nhỏ nhất khỏi heap
            // đảm bảo heap chỉ chứa k phần tử lớn nhất
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The top of the min-heap is the kth largest element
        // Đỉnh của min-heap là phần tử lớn thứ k
        return minHeap.peek();
    }

    public static void main(String[] args) {
        Solution_Heap solution = new Solution_Heap();

        // Test Case 1: [3,2,1,5,6,4], k=2 -> 5
        int[] n1 = { 3, 2, 1, 5, 6, 4 };
        System.out.println("2nd Largest: " + solution.findKthLargest(n1, 2));

        // Test Case 2: [3,2,3,1,2,4,5,5,6], k=4 -> 4
        int[] n2 = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        System.out.println("4th Largest: " + solution.findKthLargest(n2, 4));
    }
}
