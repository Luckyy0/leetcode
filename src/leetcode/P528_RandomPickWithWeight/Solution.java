package leetcode.P528_RandomPickWithWeight;

import java.util.Random;

class Solution {
    private int[] prefixSums;
    private int totalSum;
    private Random random;

    public Solution(int[] w) {
        prefixSums = new int[w.length];
        totalSum = 0;
        // Construct prefix sum array
        // Xây dựng mảng tổng tiền tố
        for (int i = 0; i < w.length; i++) {
            totalSum += w[i];
            prefixSums[i] = totalSum;
        }
        random = new Random();
    }

    public int pickIndex() {
        // Generate random number between [1, totalSum]
        // Tạo số ngẫu nhiên trong khoảng [1, totalSum]
        int target = random.nextInt(totalSum) + 1;

        // Binary search to find the first index such that prefixSums[index] >= target
        // Tìm kiếm nhị phân để tìm chỉ số đầu tiên sao cho prefixSums[index] >= target
        int left = 0, right = prefixSums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefixSums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
