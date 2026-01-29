package leetcode.P2080_RangeFrequencyQueries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RangeFreqQuery {
    Map<Integer, List<Integer>> posMap;

    public RangeFreqQuery(int[] arr) {
        posMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            posMap.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int query(int left, int right, int value) {
        if (!posMap.containsKey(value))
            return 0;
        List<Integer> list = posMap.get(value);

        // Find indices >= left
        int low = lowerBound(list, left);
        // Find indices <= right. AKA indices > right (upper bound) then substract?
        // Let's use upperBound for right inclusive.
        // Actually, upper bound of right gives index of first element > right.
        int high = upperBound(list, right);

        return high - low;
    }

    private int lowerBound(List<Integer> list, int target) {
        // First element >= target
        int l = 0, r = list.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int upperBound(List<Integer> list, int target) {
        // First element > target
        int l = 0, r = list.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
