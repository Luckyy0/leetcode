package leetcode.P870_AdvantageShuffle;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Arrays.sort(nums1);

        // Store nums2 as [value, originalIndex] in a heap descending by value
        // Luu nums2 duoi dang [gia tri, chi so goc] trong mot heap vơi gia tri giam dan
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < n; i++)
            maxHeap.add(new int[] { nums2[i], i });

        int[] res = new int[n];
        int left = 0, right = n - 1;
        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            int val = curr[0], idx = curr[1];

            if (nums1[right] > val) {
                res[idx] = nums1[right--];
            } else {
                res[idx] = nums1[left++];
            }
        }

        return res;
    }
}
