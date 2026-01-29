package leetcode.P1521_FindAValueOfAMysteriousFunctionClosestToTarget;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int closestToTarget(int[] arr, int target) {
        Set<Integer> valid = new HashSet<>();
        int minDiff = Integer.MAX_VALUE;

        for (int num : arr) {
            Set<Integer> newValid = new HashSet<>();
            newValid.add(num);
            minDiff = Math.min(minDiff, Math.abs(num - target));

            for (int v : valid) {
                int andVal = v & num;
                newValid.add(andVal);
                minDiff = Math.min(minDiff, Math.abs(andVal - target));
            }
            valid = newValid;
        }

        return minDiff;
    }
}
