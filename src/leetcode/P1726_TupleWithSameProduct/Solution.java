package leetcode.P1726_TupleWithSameProduct;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> productCount = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int p = nums[i] * nums[j];
                productCount.put(p, productCount.getOrDefault(p, 0) + 1);
            }
        }

        int result = 0;
        for (int count : productCount.values()) {
            if (count > 1) {
                result += 4 * count * (count - 1);
            }
        }

        return result;
    }
}
