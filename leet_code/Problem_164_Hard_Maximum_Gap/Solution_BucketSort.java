package leet_code.Problem_164_Hard_Maximum_Gap;

import java.util.Arrays;

public class Solution_BucketSort {

    /**
     * Finds the maximum gap between elements in sorted form using Bucket Sort in
     * O(N).
     * 
     * Tìm khoảng cách lớn nhất giữa các phần tử trong dạng đã sắp xếp sử dụng Sắp
     * xếp theo thùng với O(N).
     */
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        // 1. Find the range
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        if (max == min)
            return 0;

        // 2. Determine bucket size and count
        // Minimum possible maximum gap is (max - min) / (n - 1)
        int n = nums.length;
        int bucketSize = Math.max(1, (max - min) / (n - 1));
        int bucketCount = (max - min) / bucketSize + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        boolean[] isBucketEmpty = new boolean[bucketCount];

        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        Arrays.fill(isBucketEmpty, true);

        // 3. Put elements into buckets
        for (int i : nums) {
            int bucketIdx = (i - min) / bucketSize;
            bucketMin[bucketIdx] = Math.min(bucketMin[bucketIdx], i);
            bucketMax[bucketIdx] = Math.max(bucketMax[bucketIdx], i);
            isBucketEmpty[bucketIdx] = false;
        }

        // 4. Calculate max gap between buckets
        int maxGap = 0;
        int prevMax = min;

        for (int i = 0; i < bucketCount; i++) {
            if (isBucketEmpty[i])
                continue;

            // Gap is current bucket's min minus previous bucket's max
            maxGap = Math.max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }

        return maxGap;
    }

    public static void main(String[] args) {
        Solution_BucketSort solution = new Solution_BucketSort();

        // Test Case 1: [3,6,9,1] -> 3
        int[] n1 = { 3, 6, 9, 1 };
        System.out.println("Test Case 1: " + solution.maximumGap(n1));

        // Test Case 2: [10] -> 0
        int[] n2 = { 10 };
        System.out.println("Test Case 2: " + solution.maximumGap(n2));
    }
}
