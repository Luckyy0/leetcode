package leetcode.P638_ShoppingOffers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        // Memoization map
        // Bản đồ ghi nhớ
        Map<List<Integer>, Integer> memo = new HashMap<>();
        return dfs(price, special, needs, memo);
    }

    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs,
            Map<List<Integer>, Integer> memo) {
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }

        // Calculate basic cost (buying everything directly)
        // Tính chi phí cơ bản (mua mọi thứ trực tiếp)
        int minCost = dot(needs, price);

        for (List<Integer> offer : special) {
            List<Integer> remainingNeeds = new ArrayList<>(needs);
            boolean valid = true;

            // Check if offer is applicable
            // Kiểm tra xem ưu đãi có áp dụng được không
            for (int i = 0; i < needs.size(); i++) {
                int diff = needs.get(i) - offer.get(i);
                if (diff < 0) {
                    valid = false;
                    break;
                }
                remainingNeeds.set(i, diff);
            }

            if (valid) {
                // Recursively find min cost for remainder
                // Đệ quy tìm chi phí tối thiểu cho phần còn lại
                minCost = Math.min(minCost, offer.get(needs.size()) + dfs(price, special, remainingNeeds, memo));
            }
        }

        memo.put(needs, minCost);
        return minCost;
    }

    private int dot(List<Integer> a, List<Integer> b) {
        int sum = 0;
        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i) * b.get(i);
        }
        return sum;
    }
}
