package leetcode.P089_GrayCode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Problem 89: Gray Code
     * Approach: Formula (i ^ (i >> 1))
     * Time Complexity: O(2^n)
     * Space Complexity: O(1) (ignoring output list)
     */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        int count = 1 << n; // 2^n

        for (int i = 0; i < count; i++) {
            result.add(i ^ (i >> 1));
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, 2);
        runTest(solution, 1);
        runTest(solution, 3);
    }

    private static void runTest(Solution s, int n) {
        System.out.println("Input: n = " + n);
        List<Integer> result = s.grayCode(n);
        System.out.println("Output: " + result);

        if (isValidGrayCode(n, result)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }

    private static boolean isValidGrayCode(int n, List<Integer> seq) {
        int size = 1 << n;
        if (seq.size() != size)
            return false;

        // Check adjacent
        for (int i = 0; i < size; i++) {
            int curr = seq.get(i);
            int next = seq.get((i + 1) % size);
            if (!isSingleBitDiff(curr, next))
                return false;
        }
        return true;
    }

    private static boolean isSingleBitDiff(int a, int b) {
        int diff = a ^ b;
        return diff != 0 && (diff & (diff - 1)) == 0;
    }
}
