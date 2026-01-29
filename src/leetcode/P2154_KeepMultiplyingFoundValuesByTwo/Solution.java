package leetcode.P2154_KeepMultiplyingFoundValuesByTwo;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums)
            set.add(x);

        while (set.contains(original)) {
            original *= 2;
        }

        return original;
    }
}
