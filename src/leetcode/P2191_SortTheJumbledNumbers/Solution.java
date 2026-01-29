package leetcode.P2191_SortTheJumbledNumbers;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++)
            indices[i] = i;

        long[] mappedValues = new long[n];
        for (int i = 0; i < n; i++) {
            mappedValues[i] = getMapped(nums[i], mapping);
        }

        Arrays.sort(indices, (a, b) -> Long.compare(mappedValues[a], mappedValues[b]));

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = nums[indices[i]];
        }
        return result;
    }

    private long getMapped(int num, int[] mapping) {
        if (num == 0)
            return mapping[0];

        long res = 0;
        long multiplier = 1;
        int temp = num;

        while (temp > 0) {
            int digit = temp % 10;
            res += mapping[digit] * multiplier;
            multiplier *= 10;
            temp /= 10;
        }

        return res;
    }
}
