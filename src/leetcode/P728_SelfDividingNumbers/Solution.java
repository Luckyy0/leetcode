package leetcode.P728_SelfDividingNumbers;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i))
                res.add(i);
        }
        return res;
    }

    private boolean isSelfDividing(int n) {
        int temp = n;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 0 || n % digit != 0)
                return false;
            temp /= 10;
        }
        return true;
    }
}
