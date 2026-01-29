package leetcode.P1231_DivideChocolate;

class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        int left = 1;
        int right = 0;
        for (int s : sweetness)
            right += s;

        // Since we want max of min, assume range [1, total].
        // If check(m) is true, maybe larger possible -> left = m + 1.
        // Answer is usually right side of range in search? Or left-1.
        // Let's use template: while left <= right.

        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canDivide(sweetness, k + 1, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    // Can we get 'pieces' chunks each with sum >= minSum?
    private boolean canDivide(int[] arr, int pieces, int minSum) {
        int count = 0;
        int currentSum = 0;
        for (int x : arr) {
            currentSum += x;
            if (currentSum >= minSum) {
                count++;
                currentSum = 0;
            }
        }
        return count >= pieces;
    }
}
