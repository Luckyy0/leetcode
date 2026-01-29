package leetcode.P1640_CheckArrayFormationThroughConcatenation;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] p : pieces) {
            map.put(p[0], p);
        }

        int i = 0;
        while (i < arr.length) {
            if (!map.containsKey(arr[i])) {
                return false;
            }

            int[] piece = map.get(arr[i]);
            for (int val : piece) {
                if (i >= arr.length || arr[i] != val) {
                    return false;
                }
                i++;
            }
        }

        return true;
    }
}
