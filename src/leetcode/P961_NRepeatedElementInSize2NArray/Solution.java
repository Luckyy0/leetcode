package leetcode.P961_NRepeatedElementInSize2NArray;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (set.contains(x))
                return x;
            set.add(x);
        }
        return -1;
    }
}
