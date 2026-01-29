package leetcode.P1868_ProductOfTwoRunLengthEncodedArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> result = new ArrayList<>();
        int i = 0, j = 0;
        int freq1 = 0, freq2 = 0;

        while (i < encoded1.length && j < encoded2.length) {
            // Load freqs if empty
            if (freq1 == 0)
                freq1 = encoded1[i][1];
            if (freq2 == 0)
                freq2 = encoded2[j][1];

            int len = Math.min(freq1, freq2);
            int val = encoded1[i][0] * encoded2[j][0];

            // Append to result
            if (!result.isEmpty() && result.get(result.size() - 1).get(0) == val) {
                int lastIdx = result.size() - 1;
                int currentLen = result.get(lastIdx).get(1);
                result.get(lastIdx).set(1, currentLen + len);
            } else {
                result.add(Arrays.asList(val, len));
            }

            freq1 -= len;
            freq2 -= len;

            if (freq1 == 0)
                i++;
            if (freq2 == 0)
                j++;
        }

        return result;
    }
}
