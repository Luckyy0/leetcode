package leet_code.Problem_849_Medium_Maximize_Distance_to_Closest_Person;

/**
 * Problem 849: Maximize Distance to Closest Person
 * https://leetcode.com/problems/maximize-distance-to-closest-person/
 */
public class Solution {

    /**
     * Finds the maximum distance to the closest person.
     * Strategy: Scan the seats and calculate distances for three cases:
     * 1. The left-most gap (before the first person).
     * 2. The gaps between two people (distance is halved).
     * 3. The right-most gap (after the last person).
     * 
     * @param seats Array where 1 is occupied and 0 is empty.
     * @return Maximum distance.
     * 
     *         Tóm tắt chiến lược:
     *         Chúng ta xét 3 trường hợp:
     *         1. Khoảng trống phía đầu hàng: Nếu ghế đầu tiên trống, Alex có thể
     *         ngồi
     *         đó, khoảng cách là vị trí của người đầu tiên.
     *         2. Khoảng trống ở giữa 2 người: Alex nên ngồi chính giữa, khoảng cách
     *         là (vị trí người sau - vị trí người trước) / 2.
     *         3. Khoảng trống cuối hàng: Alex có thể ngồi ở ghế cuối cùng, khoảng
     *         cách
     *         là (n-1 - vị trí người cuối cùng).
     */
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int prev = -1;
        int maxDist = 0;

        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                if (prev == -1) {
                    // Case 1: Gap at the very beginning
                    maxDist = i;
                } else {
                    // Case 2: Gap between two occupied seats
                    maxDist = Math.max(maxDist, (i - prev) / 2);
                }
                prev = i;
            }
        }

        // Case 3: Gap at the very end
        maxDist = Math.max(maxDist, (n - 1) - prev);

        return maxDist;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] s1 = { 1, 0, 0, 0, 1, 0, 1 };
        System.out.println("Result: " + sol.maxDistToClosest(s1)); // 2

        int[] s2 = { 1, 0, 0, 0 };
        System.out.println("Result: " + sol.maxDistToClosest(s2)); // 3
    }
}
