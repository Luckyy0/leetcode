package leetcode.P1713_MinimumOperationsToMakeASubsequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            map.put(target[i], i);
        }

        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                list.add(map.get(num));
            }
        }

        // Find LIS on list
        List<Integer> tails = new ArrayList<>();
        for (int num : list) {
            if (tails.isEmpty() || num > tails.get(tails.size() - 1)) {
                tails.add(num);
            } else {
                // Binary search to replace
                int l = 0, r = tails.size() - 1;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (tails.get(mid) < num) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                tails.set(l, num);
            }
        }

        return target.length - tails.size();
    }
}
