package leetcode.P1954_MinimumGardenPerimeterToCollectEnoughApples;

public class Solution {
    public long minimumPerimeter(long neededApples) {
        long low = 1, high = 100000;
        long ans = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long count = 2 * mid * (mid + 1) * (2 * mid + 1);
            if (count >= neededApples) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return 8 * ans;
    }
}
