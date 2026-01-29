package leetcode.P1588_SumOfAllOddLengthSubarrays;

public class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            // Number of ways to choose start index (0 to i)
            int startOptions = i + 1;
            // Number of ways to choose end index (i to n-1)
            int endOptions = n - i;

            // Total subarrays containing arr[i]
            int totalSubarrays = startOptions * endOptions;

            // Number of odd length subarrays is ceil(total / 2)
            int oddSubarrays = (totalSubarrays + 1) / 2;

            sum += arr[i] * oddSubarrays;
        }

        return sum;
    }
}
