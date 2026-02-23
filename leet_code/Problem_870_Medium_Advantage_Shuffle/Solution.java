package leet_code.Problem_870_Medium_Advantage_Shuffle;

import java.util.*;

/**
 * Problem 870: Advantage Shuffle
 * https://leetcode.com/problems/advantage-shuffle/
 */
public class Solution {

    /**
     * Rearranges nums1 to maximize the number of indices where nums1[i] > nums2[i].
     * Strategy: Greedy "Tian Ji Horse Racing". Compare the strongest available in
     * nums1
     * with the strongest in nums2.
     * 
     * @param nums1 The array to be reordered.
     * @param nums2 The target array.
     * @return An advantaged permutation of nums1.
     * 
     *         Tóm tắt chiến lược:
     *         Chúng ta sắp xếp cả hai mảng.
     *         1. Duyệt qua các phần tử của nums2 từ cao xuống thấp.
     *         2. Nếu quân mạnh nhất của ta (right) thắng được quân mạnh nhất của
     *         họ, hãy dùng nó.
     *         3. Ngược lại, quân mạnh nhất của ta không thắng nổi, vậy quân nào
     *         cũng thua.
     *         Ta dùng quân yếu nhất (left) để hy sinh tại vị trí đó để giữ quân
     *         mạnh cho lượt sau.
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] result = new int[n];

        // Sort nums1 for two-pointer access
        Arrays.sort(nums1);

        // Use a Max-Heap to track the largest elements of nums2 and their indices
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < n; i++) {
            maxHeap.offer(new int[] { nums2[i], i });
        }

        int left = 0; // weakest in nums1
        int right = n - 1; // strongest in nums1

        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            int val = curr[0];
            int idx = curr[1];

            // If our strongest wins against their strongest
            if (nums1[right] > val) {
                result[idx] = nums1[right];
                right--;
            }
            // Otherwise, sacrifice our weakest
            else {
                result[idx] = nums1[left];
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] n1 = { 2, 7, 11, 15 };
        int[] n2 = { 1, 10, 4, 11 };
        System.out.println("Result: " + Arrays.toString(sol.advantageCount(n1, n2)));
        // Likely: [2, 11, 7, 15]

        int[] n1_2 = { 12, 24, 8, 32 };
        int[] n2_2 = { 13, 25, 32, 11 };
        System.out.println("Result: " + Arrays.toString(sol.advantageCount(n1_2, n2_2)));
        // Likely: [24, 32, 8, 12]
    }
}
