package leetcode.P2111_MinimumOperationsToMakeTheArrayKIncreasing;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int kIncreasing(int[] arr, int k) {
        int ops = 0;
        int n = arr.length;

        for (int i = 0; i < k; i++) {
            List<Integer> sub = new ArrayList<>();
            for (int j = i; j < n; j += k) {
                sub.add(arr[j]);
            }

            ops += sub.size() - lengthOfLNDS(sub);
        }

        return ops;
    }

    private int lengthOfLNDS(List<Integer> sub) {
        List<Integer> piles = new ArrayList<>();
        for (int num : sub) {
            // Find first element > num (for strictly increasing)
            // But we want Non-Decreasing. So find first element > num.
            // Wait. If we replace first > num, we maintain non-decreasing?
            // Standard LIS (strictly increasing): find first >= num.
            // Standard LNDS (non-decreasing): find first > num.
            int idx = upperBound(piles, num);
            if (idx == piles.size()) {
                piles.add(num);
            } else {
                piles.set(idx, num);
            }
        }
        return piles.size();
    }

    private int upperBound(List<Integer> list, int target) {
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
