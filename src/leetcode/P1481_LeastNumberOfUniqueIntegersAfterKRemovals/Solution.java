package leetcode.P1481_LeastNumberOfUniqueIntegersAfterKRemovals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int x : arr)
            counts.put(x, counts.getOrDefault(x, 0) + 1);

        List<Integer> freqs = new ArrayList<>(counts.values());
        Collections.sort(freqs);

        int removed = 0;
        for (int f : freqs) {
            if (k >= f) {
                k -= f;
                removed++;
            } else {
                break;
            }
        }

        return freqs.size() - removed;
    }
}
