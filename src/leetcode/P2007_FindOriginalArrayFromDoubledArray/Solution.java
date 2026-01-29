package leetcode.P2007_FindOriginalArrayFromDoubledArray;

import java.util.Arrays;

public class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0)
            return new int[0];

        int max = 0;
        for (int x : changed)
            max = Math.max(max, x);

        int[] freq = new int[max + 1];
        for (int x : changed)
            freq[x]++;

        int[] res = new int[changed.length / 2];
        int idx = 0;

        // Handle 0
        if (freq[0] % 2 != 0)
            return new int[0];
        for (int i = 0; i < freq[0] / 2; i++)
            res[idx++] = 0;

        // Handle positive
        for (int i = 1; i <= max; i++) {
            if (freq[i] > 0) {
                int count = freq[i];
                if (2 * i > max || freq[2 * i] < count)
                    return new int[0];

                freq[2 * i] -= count;
                for (int k = 0; k < count; k++)
                    res[idx++] = i;
            }
        }

        return res;
    }
}
