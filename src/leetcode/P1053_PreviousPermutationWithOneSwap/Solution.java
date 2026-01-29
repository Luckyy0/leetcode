package leetcode.P1053_PreviousPermutationWithOneSwap;

class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        int i = n - 2;
        // 1. Find the first index i from right such that arr[i] > arr[i+1]
        while (i >= 0 && arr[i] <= arr[i + 1]) {
            i--;
        }

        if (i < 0)
            return arr;

        // 2. Find the largest element to the right of i that is smaller than arr[i]
        // Since arr[i] > arr[i+1] and everything after i was non-decreasing (from right
        // view logic? No wait.)
        // Actually the suffix starting i+1 is non-decreasing?
        // Example: 3, 2, 1. i=1 (2). arr[i] > arr[i+1] (2>1). Suffix from i+1 is [1].
        // Example: 1, 9, 4, 6, 7. i=1 (9). Suffix 4, 6, 7. This suffix 4, 6, 7 is
        // increasing.
        // So we can binary search or just linear search since we need specific
        // property.

        int j = n - 1;
        while (arr[j] >= arr[i] || arr[j] == arr[j - 1]) {
            // Skip elements >= arr[i]
            // Skip duplicates to find "first" one (leftmost)
            // Wait, logic for duplicates:
            // We want largest value < arr[i].
            // If we have [1, 9, 4, 6, 4, 7]. i=1 (9). We want max < 9. That is 7? No 6? No
            // 7.
            // arr[5]=7. Suffix [4, 6, 4, 7].
            // Is suffix sorted? arr[i] > arr[i+1] means finding from right, first time it
            // increases is at i.
            // So arr[i+1...n-1] is increasing. like 4, 6, 7.
            // Wait, example: 3, 1, 1, 3. i=0 (3). Suffix 1, 1, 3. 1<=1<=3. Yes increasing.
            // So we just iterate from right. Find first element < arr[i].
            // But we must handle duplicates. e.g. suffix is 1, 1, 3.
            // First < 3 is 1 (index 2). But 1 at index 1 is same. We want index 1.
            // So while arr[j] == arr[j-1], j--.
            j--;
        }

        // Correct loop:
        // Since suffix is increasing, we look for largest element < arr[i].
        // This will be towards the end.
        // 1, 9, 4, 6, 7. Suffix 4, 6, 7. Largest < 9 is 7.
        // 3, 1, 1, 3. Suffix 1, 1, 3. Largest < 3 is 1. Two 1s. We want leftmost 1.

        // Let's rewrite finding j part simply:
        int maxVal = -1;
        int maxIdx = -1;
        for (int k = i + 1; k < n; k++) {
            if (arr[k] < arr[i]) {
                if (arr[k] > maxVal) {
                    maxVal = arr[k];
                    maxIdx = k;
                }
                // If equal, we don't update, keeping the leftmost (first one we saw? No, we
                // iterate L->R)
                // If we iterate L->R (i+1 to n), the first one is leftmost.
                // But logic above says: we want largest value.
                // e.g. 4, 6, 4. 6 > 4. we take 6.
                // e.g. 4, 4. we take first 4.
            }
        }

        // Optimization: suffix is sorted.
        // We can just iterate backwards to find first < arr[i].
        // Then while prev is same, move back.
        int targetIdx = n - 1;
        while (arr[targetIdx] >= arr[i]) {
            targetIdx--;
        }
        // Now arr[targetIdx] < arr[i]. Check duplicates.
        while (targetIdx > i + 1 && arr[targetIdx] == arr[targetIdx - 1]) {
            targetIdx--;
        }

        // Swap
        int temp = arr[i];
        arr[i] = arr[targetIdx];
        arr[targetIdx] = temp;

        return arr;
    }
}
