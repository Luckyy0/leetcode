package leetcode.P1426_CountingElements;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int countElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int x : arr)
            set.add(x);

        int count = 0;
        for (int x : arr) {
            if (set.contains(x + 1)) {
                count++;
            }
        }

        return count;
    }
}
