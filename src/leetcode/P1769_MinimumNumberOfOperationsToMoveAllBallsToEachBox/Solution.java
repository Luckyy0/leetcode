package leetcode.P1769_MinimumNumberOfOperationsToMoveAllBallsToEachBox;

public class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] result = new int[n];

        int count = 0;
        int ops = 0;
        for (int i = 0; i < n; i++) {
            result[i] += ops;
            if (boxes.charAt(i) == '1')
                count++;
            ops += count;
        }

        count = 0;
        ops = 0;
        for (int i = n - 1; i >= 0; i--) {
            result[i] += ops;
            if (boxes.charAt(i) == '1')
                count++;
            ops += count;
        }

        return result;
    }
}
