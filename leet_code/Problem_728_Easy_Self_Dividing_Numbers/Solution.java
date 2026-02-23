package leet_code.Problem_728_Easy_Self_Dividing_Numbers;

import java.util.*;

public class Solution {

    /**
     * Finds all self-dividing numbers in the range [left, right].
     * Strategy: Iterate and verify each number using digit extraction.
     * Time: O(N * D), Space: O(1) auxiliary.
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int n = left; n <= right; n++) {
            if (isSelfDividing(n)) {
                res.add(n);
            }
        }
        return res;
    }

    private boolean isSelfDividing(int n) {
        int temp = n;
        while (temp > 0) {
            int d = temp % 10;
            // Condition 1: Must not contain digit 0
            // Condition 2: n must be divisible by d
            if (d == 0 || n % d != 0) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.selfDividingNumbers(1, 22)); // [1, 2, 3... 22]
        System.out.println(sol.selfDividingNumbers(47, 85)); // [48, 55, 66, 77]
    }
}
