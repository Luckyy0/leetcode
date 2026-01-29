package leetcode.P2200_FindAllKDistantIndicesInAnArray;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();

        // We can optimize the marking to avoid re-adding
        // Track the last index added to result to avoid duplicates
        // Iterate j (key positions). Add range [max(last+1, j-k), j+k]

        int lastAdded = -1;
        for (int j = 0; j < n; j++) {
            if (nums[j] == key) {
                int start = Math.max(lastAdded + 1, j - k);
                int end = Math.min(n - 1, j + k);

                for (int i = start; i <= end; i++) {
                    res.add(i);
                }
                lastAdded = end;
            }
        }

        return res;
    }
}
