package leetcode.P823_BinaryTreesWithFactors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        long mod = 1_000_000_007;
        Arrays.sort(arr);
        Map<Integer, Long> dp = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            dp.put(arr[i], 1L);
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int other = arr[i] / arr[j];
                    if (dp.containsKey(other)) {
                        dp.put(arr[i], (dp.get(arr[i]) + dp.get(arr[j]) * dp.get(other)) % mod);
                    }
                }
            }
        }

        long total = 0;
        for (long count : dp.values()) {
            total = (total + count) % mod;
        }

        return (int) total;
    }
}
