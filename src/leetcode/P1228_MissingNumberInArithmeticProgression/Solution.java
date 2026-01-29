package leetcode.P1228_MissingNumberInArithmeticProgression;

class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int expectedSum = (arr[0] + arr[n - 1]) * (n + 1) / 2;
        int actualSum = 0;
        for (int x : arr)
            actualSum += x;

        return expectedSum - actualSum; // Works even if diff is 0?
        // If diff 0: expected = (a+a)*(n+1)/2 = 2a*(n+1)/2 = a(n+1).
        // Actual = a*n. Diff = a. Correct.
    }
}
