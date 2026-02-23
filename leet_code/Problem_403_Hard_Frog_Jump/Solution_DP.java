package leet_code.Problem_403_Hard_Frog_Jump;

import java.util.*;

public class Solution_DP {

    /**
     * Determines if the frog can reach the last stone.
     * Uses DP with a Map of Sets.
     * Time: O(N^2), Space: O(N^2).
     * 
     * Xác định liệu con ếch có thể đến được tảng đá cuối cùng không.
     * Sử dụng quy hoạch động với một Bản đồ các Tập hợp.
     */
    public boolean canCross(int[] stones) {
        int n = stones.length;
        // map: stone position -> set of jump sizes that can reach this stone
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }

        // Initial state: on first stone (0), incoming jump was 0 but first must be 1
        // Trạng thái ban đầu: ở tảng đá đầu tiên (0)
        map.get(0).add(0);

        for (int i = 0; i < n; i++) {
            int currentStone = stones[i];
            Set<Integer> jumps = map.get(currentStone);

            for (int k : jumps) {
                // Try jumps: k-1, k, k+1
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(currentStone + step)) {
                        map.get(currentStone + step).add(step);
                    }
                }
            }
        }

        return !map.get(stones[n - 1]).isEmpty();
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1: [0,1,3,5,6,8,12,17] -> true
        System.out.println("Result 1: " + solution.canCross(new int[] { 0, 1, 3, 5, 6, 8, 12, 17 }));

        // Test Case 2: [0,1,2,3,4,8,9,11] -> false
        System.out.println("Result 2: " + solution.canCross(new int[] { 0, 1, 2, 3, 4, 8, 9, 11 }));
    }
}
