package leetcode.P1333_FilterRestaurantsByVeganFriendlyPriceAndDistance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> filtered = new ArrayList<>();

        for (int[] r : restaurants) {
            if (veganFriendly == 1 && r[2] == 0)
                continue;
            if (r[3] > maxPrice)
                continue;
            if (r[4] > maxDistance)
                continue;
            filtered.add(r);
        }

        Collections.sort(filtered, (a, b) -> {
            if (a[1] != b[1])
                return b[1] - a[1]; // Rating desc
            return b[0] - a[0]; // ID desc
        });

        List<Integer> res = new ArrayList<>();
        for (int[] r : filtered)
            res.add(r[0]);
        return res;
    }
}
