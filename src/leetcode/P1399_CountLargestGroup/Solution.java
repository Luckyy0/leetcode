package leetcode.P1399_CountLargestGroup;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxSize = 0;

        for (int i = 1; i <= n; i++) {
            int sum = getSum(i);
            int count = map.getOrDefault(sum, 0) + 1;
            map.put(sum, count);
            maxSize = Math.max(maxSize, count);
        }

        int result = 0;
        for (int size : map.values()) {
            if (size == maxSize) {
                result++;
            }
        }

        return result;
    }

    private int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
