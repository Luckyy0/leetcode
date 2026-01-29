package leetcode.P1964_FindTheLongestValidObstacleCourseAtEachPosition;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] ans = new int[n];
        List<Integer> tails = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = obstacles[i];

            // Find first element > x (Upper Bound)
            int low = 0, high = tails.size();
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (tails.get(mid) > x) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            // low is insertion index
            if (low == tails.size()) {
                tails.add(x);
            } else {
                tails.set(low, x);
            }

            ans[i] = low + 1;
        }

        return ans;
    }
}
