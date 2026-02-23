package leet_code.Problem_923_Medium_3Sum_With_Multiplicity;

/**
 * Problem 923: 3Sum With Multiplicity
 * https://leetcode.com/problems/3sum-with-multiplicity/
 */
public class Solution {

    /**
     * Counts the number of tuples (i, j, k) such that arr[i] + arr[j] + arr[k] ==
     * target.
     * Strategy: Frequency Counting + Combinatorics.
     * 
     * @param arr    Input array.
     * @param target Target sum.
     * @return Number of tuples modulo 10^9 + 7.
     * 
     *         Tóm tắt chiến lược:
     *         1. Vì giá trị trong mảng nhỏ (từ 0 đến 100), ta có thể đếm tần suất
     *         xuất hiện của mỗi số.
     *         2. Duyệt qua tất cả các cặp số (x, y) trong khoảng [0, 100] sao cho x
     *         <= y.
     *         3. Tính số thứ 3 cần thiết: z = target - x - y.
     *         4. Kiểm tra z có hợp lệ không (z >= y và z <= 100).
     *         5. Tính số cách chọn bộ ba (x, y, z) dựa trên số lượng của chúng
     *         trong mảng:
     *         - Nếu x == y == z: C(count[x], 3)
     *         - Nếu x == y != z: C(count[x], 2) * count[z]
     *         - Nếu x != y == z: count[x] * C(count[y], 2)
     *         - Nếu x != y != z: count[x] * count[y] * count[z]
     *         6. Cộng dồn kết quả và lấy modulo.
     */
    public int threeSumMulti(int[] arr, int target) {
        long MOD = 1_000_000_007;
        long[] count = new long[101];

        // Count frequency of each number
        for (int x : arr) {
            count[x]++;
        }

        long ans = 0;

        // Iterate through all unique combinations of x and y
        for (int x = 0; x <= 100; x++) {
            for (int y = x; y <= 100; y++) {
                int z = target - x - y;

                // Ensure z is within valid range and maintains order x <= y <= z
                // to avoid double counting combinations.
                if (z > 100 || z < y) {
                    continue;
                }

                if (x == y && y == z) {
                    // Case: x, x, x
                    // Need to choose 3 indices from count[x] available positions
                    ans += count[x] * (count[x] - 1) * (count[x] - 2) / 6;
                } else if (x == y && y != z) {
                    // Case: x, x, z
                    // Choose 2 indices for x and 1 index for z
                    ans += count[x] * (count[x] - 1) / 2 * count[z];
                } else if (x < y && y == z) {
                    // Case: x, y, y
                    // Choose 1 index for x and 2 indices for y
                    ans += count[x] * count[y] * (count[y] - 1) / 2;
                } else {
                    // Case: x, y, z (all distinct)
                    // Choose 1 index for each
                    ans += count[x] * count[y] * count[z];
                }

                ans %= MOD;
            }
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.threeSumMulti(new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 }, 8)); // 20
        System.out.println("Result: " + sol.threeSumMulti(new int[] { 1, 1, 2, 2, 2, 2 }, 5)); // 12
    }
}
