package leetcode.P2195_AppendKIntegersWithMinimalSum;

import java.util.Arrays;

public class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0;
        long current = 1;

        for (int x : nums) {
            if (x < current)
                continue; // Duplicate or already passed

            // Available range [current, x-1]
            long count = x - current;
            if (count > 0) {
                long take = Math.min(k, count);
                // Sum of take integers starting at current
                // current, current+1, ..., current+take-1
                // Sum = take * current + take*(take-1)/2
                sum += take * current + take * (take - 1) / 2;
                k -= take;
                if (k == 0)
                    return sum;
            }
            current = (long) x + 1;
        }

        if (k > 0) {
            sum += (long) k * current + (long) k * (k - 1) / 2;
        }

        return sum;
    }
}
