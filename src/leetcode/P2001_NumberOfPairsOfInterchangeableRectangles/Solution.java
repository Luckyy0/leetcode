package leetcode.P2001_NumberOfPairsOfInterchangeableRectangles;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<String, Integer> map = new HashMap<>();
        long pairs = 0;

        for (int[] rect : rectangles) {
            int w = rect[0];
            int h = rect[1];
            int g = gcd(w, h);
            String key = (w / g) + ":" + (h / g);

            // If count is k, adding 1 makes k pairs with existing.
            // Or accumulate total count and calc n*(n-1)/2 later.
            // Here accumulating incrementally:
            int count = map.getOrDefault(key, 0);
            pairs += count;
            map.put(key, count + 1);
        }

        return pairs;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
