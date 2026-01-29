package leetcode.P1018_BinaryPrefixDivisibleBy5;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>();
        int curr = 0;
        for (int bit : nums) {
            curr = (curr * 2 + bit) % 5;
            res.add(curr == 0);
        }
        return res;
    }
}
