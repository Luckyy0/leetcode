package leetcode.P1243_ArrayTransformation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> transformArray(int[] arr) {
        int[] curr = arr.clone();
        boolean changed = true;

        while (changed) {
            changed = false;
            int[] next = curr.clone();

            for (int i = 1; i < curr.length - 1; i++) {
                if (curr[i] < curr[i - 1] && curr[i] < curr[i + 1]) {
                    next[i]++;
                    changed = true;
                } else if (curr[i] > curr[i - 1] && curr[i] > curr[i + 1]) {
                    next[i]--;
                    changed = true;
                }
            }
            curr = next;
        }

        return Arrays.stream(curr).boxed().collect(Collectors.toList());
    }
}
