package leetcode.P2089_FindTargetIndicesAfterSortingArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int less = 0;
        int equal = 0;
        for (int x : nums) {
            if (x < target)
                less++;
            else if (x == target)
                equal++;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < equal; i++) {
            res.add(less + i);
        }
        return res; // Already sorted
    }
}
