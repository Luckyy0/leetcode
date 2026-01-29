package leetcode.P1802_MaximumValueAtAGivenIndexInABoundedArray;

public class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int left = 1;
        int right = maxSum;
        int ans = 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(n, index, mid, maxSum)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean check(int n, int index, int val, int maxSum) {
        long sum = val;

        // Left side: index elements
        int leftLen = index;
        sum += getSum(leftLen, val - 1);

        // Right side: n - 1 - index elements
        int rightLen = n - 1 - index;
        sum += getSum(rightLen, val - 1);

        return sum <= maxSum;
    }

    private long getSum(int len, int startVal) {
        if (len == 0)
            return 0;
        if (startVal >= len) {
            long endVal = startVal - len + 1;
            return (long) (startVal + endVal) * len / 2;
        } else {
            // Decreases to 1, then rest are 1s
            long decPart = (long) (startVal + 1) * startVal / 2;
            long ones = len - startVal;
            return decPart + ones;
        }
    }
}
