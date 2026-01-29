package leetcode.P1674_MinimumMovesToMakeArrayComplementary;

public class Solution {
    public int minMoves(int[] nums, int limit) {
        int[] diff = new int[2 * limit + 2];
        int n = nums.length;

        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];
            int min = Math.min(a, b);
            int max = Math.max(a, b);

            // Base cost 2 everywhere (conceptually, handled by initial diff? No, easier to
            // just apply delta)
            // Let's assume global baseline cost is 0 and we add cost.
            // Range [2, 2*limit] costs:
            // [2, min + 1): 2 moves
            // [min + 1, max + limit]: 1 move. EXCEPT sum=a+b is 0 moves.
            // (max + limit, 2*limit]: 2 moves.

            // Implementation with diff array updates:
            // Delta for 2 moves: diff[2] += 2, diff[2*limit + 1] -= 2
            diff[2] += 2;
            diff[2 * limit + 1] -= 2;

            // Delta for 1 move (reduce from 2 to 1): range [min + 1, max + limit]
            diff[min + 1] -= 1;
            diff[max + limit + 1] += 1;

            // Delta for 0 moves (reduce from 1 to 0): point [sum]
            int sum = a + b;
            diff[sum] -= 1;
            diff[sum + 1] += 1;
        }

        int minMoves = Integer.MAX_VALUE;
        int currentMoves = 0;

        for (int k = 2; k <= 2 * limit; k++) {
            currentMoves += diff[k];
            minMoves = Math.min(minMoves, currentMoves);
        }

        return minMoves;
    }
}
