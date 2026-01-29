package leetcode.P2098_SubsequenceOfSizeKWithTheLargestEvenSum;

import java.util.Arrays;

public class Solution {
    public long largestEvenSum(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        long sum = 0;

        // Take top k
        for (int i = n - 1; i >= n - k; i--) {
            sum += nums[i];
        }

        if (sum % 2 == 0)
            return sum;

        // Sum is odd. Need to swap.
        // Option 1: Swap smallest selected Odd with largest unselected Even
        int minSelOdd = -1;
        for (int i = n - k; i < n; i++) {
            if (nums[i] % 2 != 0) {
                minSelOdd = nums[i]; // Smallest will be at lowest index in selection (which is n-k)
                break;
            }
        }

        int maxUnselEven = -1;
        for (int i = n - k - 1; i >= 0; i--) {
            if (nums[i] % 2 == 0) {
                maxUnselEven = nums[i];
                break;
            }
        }

        // Option 2: Swap smallest selected Even with largest unselected Odd
        int minSelEven = -1;
        for (int i = n - k; i < n; i++) {
            if (nums[i] % 2 == 0) {
                minSelEven = nums[i];
                break;
            }
        }

        int maxUnselOdd = -1;
        for (int i = n - k - 1; i >= 0; i--) {
            if (nums[i] % 2 != 0) {
                maxUnselOdd = nums[i];
                break;
            }
        }

        long ans = -1;

        if (minSelOdd != -1 && maxUnselEven != -1) {
            ans = Math.max(ans, sum - minSelOdd + maxUnselEven);
        }

        if (minSelEven != -1 && maxUnselOdd != -1) {
            ans = Math.max(ans, sum - minSelEven + maxUnselOdd);
        }

        return ans;
    }
}
