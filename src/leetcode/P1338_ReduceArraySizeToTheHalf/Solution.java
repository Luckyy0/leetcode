package leetcode.P1338_ReduceArraySizeToTheHalf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> counts = new HashMap<>();
        for (int x : arr)
            counts.put(x, counts.getOrDefault(x, 0) + 1);

        List<Integer> freqs = new ArrayList<>(counts.values());
        Collections.sort(freqs, Collections.reverseOrder());

        int removed = 0;
        int setSize = 0;

        for (int f : freqs) {
            removed += f;
            setSize++;
            if (removed >= n / 2)
                return setSize;
        }

        return setSize;
    }
}
