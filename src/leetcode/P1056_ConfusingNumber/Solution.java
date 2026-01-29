package leetcode.P1056_ConfusingNumber;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean confusingNumber(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);

        int original = n;
        int rotated = 0;

        while (n > 0) {
            int d = n % 10;
            if (!map.containsKey(d))
                return false;
            rotated = rotated * 10 + map.get(d);
            n /= 10;
        }

        return rotated != original;
    }
}
