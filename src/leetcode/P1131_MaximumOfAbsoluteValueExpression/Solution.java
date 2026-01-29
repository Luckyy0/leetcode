package leetcode.P1131_MaximumOfAbsoluteValueExpression;

class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int maxVal = 0;
        int n = arr1.length;

        // 4 cases: (1, 1), (1, -1), (-1, 1), (-1, -1) for coefficients of arr1 and
        // arr2.
        // The term for index 'k' will always be +k (relative).
        // Formula: s1*arr1[k] + s2*arr2[k] + k

        int[] signs = { 1, -1 };
        for (int s1 : signs) {
            for (int s2 : signs) {
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;

                for (int i = 0; i < n; i++) {
                    int val = s1 * arr1[i] + s2 * arr2[i] + i;
                    min = Math.min(min, val);
                    max = Math.max(max, val);
                }
                maxVal = Math.max(maxVal, max - min);
            }
        }

        return maxVal;
    }
}
