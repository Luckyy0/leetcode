package leetcode.P1187_MakeArrayStrictlyIncreasing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        // Sort and unique arr2
        TreeSet<Integer> set = new TreeSet<>();
        for (int x : arr2)
            set.add(x);
        int[] sortedArr2 = new int[set.size()];
        int idx = 0;
        for (int x : set)
            sortedArr2[idx++] = x;

        // DP: Map<EndValue, MinOps>
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(-1, 0);

        for (int val1 : arr1) {
            Map<Integer, Integer> nextDp = new HashMap<>();

            for (int prevVal : dp.keySet()) {
                int prevOps = dp.get(prevVal);

                // Option 1: Keep current val1
                if (val1 > prevVal) {
                    int ops = prevOps;
                    if (!nextDp.containsKey(val1) || nextDp.get(val1) > ops) {
                        nextDp.put(val1, ops);
                    }
                }

                // Option 2: Replace with from arr2
                // Find smallest in arr2 > prevVal
                int replaceIdx = findSmallestGreater(sortedArr2, prevVal);
                if (replaceIdx != -1) {
                    int nextVal = sortedArr2[replaceIdx];
                    int ops = prevOps + 1;
                    if (!nextDp.containsKey(nextVal) || nextDp.get(nextVal) > ops) {
                        nextDp.put(nextVal, ops);
                    }
                }
            }

            if (nextDp.isEmpty())
                return -1;
            dp = nextDp;
        }

        int min = Integer.MAX_VALUE;
        for (int ops : dp.values())
            min = Math.min(min, ops);
        return min;
    }

    // Find smallest element > val
    private int findSmallestGreater(int[] arr, int val) {
        int l = 0, r = arr.length - 1;
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > val) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}
