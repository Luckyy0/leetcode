package leetcode.P1157_OnlineMajorityElementInSubarray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class MajorityChecker {
    Map<Integer, List<Integer>> pos;
    int[] arr;
    Random rand;

    public MajorityChecker(int[] arr) {
        this.arr = arr;
        pos = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            pos.putIfAbsent(arr[i], new ArrayList<>());
            pos.get(arr[i]).add(i);
        }
        rand = new Random();
    }

    public int query(int left, int right, int threshold) {
        int len = right - left + 1;
        for (int i = 0; i < 20; i++) {
            int idx = left + rand.nextInt(len);
            int candidate = arr[idx];
            List<Integer> indices = pos.get(candidate);

            // Check frequency of candidate in range [left, right]
            // We need count of indices >= left AND <= right
            int low = Collections.binarySearch(indices, left);
            int high = Collections.binarySearch(indices, right);

            if (low < 0)
                low = ~low;
            if (high < 0)
                high = ~high;
            else
                high++; // If found exact right, include it so range is [low, high)

            // Wait, binarySearch returns index in LIST.
            // If found, returns index. If not found, returns (-(insertion point) - 1).
            // Indices in list are storing actual array indices.
            // E.g. list: [1, 5, 10]. Range [2, 8].
            // Search 2: insertion point 1 (value 5). Returns -2. low = 1.
            // Search 8: insertion point 2 (value 10). Returns -3. high = 2.
            // Count = high - low = 2 - 1 = 1 (index 5 is in range). Correct.

            // If found exact:
            // list: [1, 5, 10]. Range [1, 5].
            // Search 1: index 0. low = 0.
            // Search 5: index 1. high should be "index after 5" which is 2.
            // So if exact match found for right, we want (index + 1). Use high++.

            if (high - low >= threshold)
                return candidate;
        }
        return -1;
    }
}
