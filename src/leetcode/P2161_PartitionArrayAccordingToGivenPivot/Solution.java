package leetcode.P2161_PartitionArrayAccordingToGivenPivot;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        for (int x : nums) {
            if (x < pivot)
                less.add(x);
            else if (x == pivot)
                equal.add(x);
            else
                greater.add(x);
        }

        int[] res = new int[nums.length];
        int idx = 0;
        for (int x : less)
            res[idx++] = x;
        for (int x : equal)
            res[idx++] = x;
        for (int x : greater)
            res[idx++] = x;

        return res;
    }
}
