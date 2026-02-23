package leet_code.Problem_780_Hard_Reaching_Points;

public class Solution {

    /**
     * Checks if we can reach target from source.
     * Strategy: Work backwards from target using modulo (Euclidean-like).
     * Time: O(log(min(tx, ty))), Space: O(1).
     */
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        // Work backwards
        while (tx >= sx && ty >= sy) {
            // Found exact match
            if (tx == sx && ty == sy) {
                return true;
            }

            if (tx > ty) {
                // If ty matches sy, we just need to check if we can reduce tx to sx
                // by subtracting ty multiple times (modulo logic).
                if (ty == sy) {
                    return (tx - sx) % ty == 0;
                }

                // Otherwise, perform modulo step
                // Note: if ty is large, tx % ty might skip sx,
                // but since we loop while tx >= sx, if tx % ty < sx,
                // the loop condition will catch it in next iteration?
                // Actually if tx % ty < sx, the next loop tx >= sx fails.
                // But wait, what if the valid path was stopping AT sx?
                // Example: sx=2, sy=3. tx=8, ty=3.
                // 8 > 3. ty==sy (3==3). (8-2)%3 == 0 (6%3==0). TRUE.

                // If ty != sy, we just modulo.
                // It is safe because if we overshoot sx, then tx was never reachable from sx
                // via additions of ty.
                tx %= ty;
            } else {
                // Same logic for ty > tx
                if (tx == sx) {
                    return (ty - sy) % tx == 0;
                }

                ty %= tx;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1: " + sol.reachingPoints(1, 1, 3, 5)); // true
        System.out.println("Result 2: " + sol.reachingPoints(1, 1, 2, 2)); // false
        System.out.println("Result 3: " + sol.reachingPoints(1, 1, 1, 1)); // true
    }
}
