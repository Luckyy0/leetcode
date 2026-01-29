package leetcode.P1865_FindingPairsWithACertainSum;

import java.util.HashMap;
import java.util.Map;

public class FindSumPairs {
    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> freq2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.freq2 = new HashMap<>();
        for (int val : nums2) {
            freq2.put(val, freq2.getOrDefault(val, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = nums2[index];

        freq2.put(oldVal, freq2.get(oldVal) - 1);
        if (freq2.get(oldVal) == 0) {
            freq2.remove(oldVal);
        }

        nums2[index] += val;
        int newVal = nums2[index];
        freq2.put(newVal, freq2.getOrDefault(newVal, 0) + 1);
    }

    public int count(int tot) {
        int count = 0;
        for (int val1 : nums1) {
            int target = tot - val1;
            if (freq2.containsKey(target)) {
                count += freq2.get(target);
            }
        }
        return count;
    }
}
