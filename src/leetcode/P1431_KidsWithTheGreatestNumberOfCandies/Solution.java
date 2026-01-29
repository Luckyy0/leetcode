package leetcode.P1431_KidsWithTheGreatestNumberOfCandies;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for (int c : candies)
            maxCandies = Math.max(maxCandies, c);

        List<Boolean> res = new ArrayList<>();
        for (int c : candies) {
            res.add(c + extraCandies >= maxCandies);
        }

        return res;
    }
}
