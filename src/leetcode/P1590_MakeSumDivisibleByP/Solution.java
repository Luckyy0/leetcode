package leetcode.P1590_MakeSumDivisibleByP;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minSubarray(int[] nums, int p) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int target = (int) (totalSum % p);
        if (target == 0)
            return 0;

        Map<Integer, Integer> lastPos = new HashMap<>();
        lastPos.put(0, -1);

        long currentSum = 0;
        int minLen = nums.length;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            int currentMod = (int) (currentSum % p);

            // We want (currentMod - prevMod) % p == target
            // prevMod = (currentMod - target) % p
            int needed = (currentMod - target + p) % p;

            if (lastPos.containsKey(needed)) {
                minLen = Math.min(minLen, i - lastPos.get(needed));
            }

            lastPos.put(currentMod, i);
        }

        return minLen == nums.length ? -1 : minLen;
    }
}
