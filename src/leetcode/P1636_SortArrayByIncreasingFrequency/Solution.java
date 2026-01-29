package leetcode.P1636_SortArrayByIncreasingFrequency;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        return Arrays.stream(nums)
                .boxed()
                .sorted((a, b) -> {
                    int ca = counts.get(a);
                    int cb = counts.get(b);
                    if (ca != cb)
                        return ca - cb;
                    return b - a;
                })
                .mapToInt(i -> i)
                .toArray();
    }
}
