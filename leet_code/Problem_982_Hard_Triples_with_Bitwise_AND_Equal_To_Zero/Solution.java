package leet_code.Problem_982_Hard_Triples_with_Bitwise_AND_Equal_To_Zero;

/**
 * Problem 982: Triples with Bitwise AND Equal To Zero
 * https://leetcode.com/problems/triples-with-bitwise-and-equal-to-zero/
 */
public class Solution {

    /**
     * Counts the number of triples (i, j, k) where nums[i] & nums[j] & nums[k] ==
     * 0.
     * Strategy: Precompute pairs AND frequencies.
     * 
     * @param nums Array of integers.
     * @return Count of triples.
     * 
     *         Tóm tắt chiến lược:
     *         1. Duyệt vét cạn 3 vòng lặp sẽ tốn O(N^3) ~ 10^9 thao tác, quá chậm
     *         (N <= 1000).
     *         2. Nhận xét: Giá trị của `nums[i]` nhỏ hơn 2^16 (65536).
     *         3. Số lượng cặp giá trị (nums[i] & nums[j]) là N^2 = 10^6, chấp nhận
     *         được.
     *         4. Bước 1: Duyệt tất cả các cặp (nums[i], nums[j]), tính `val =
     *         nums[i] & nums[j]`.
     *         Lưu tần suất xuất hiện của mỗi `val` vào mảng `count` kích thước
     *         2^16.
     *         5. Bước 2: Duyệt qua từng `nums[k]` và tất cả các giá trị `val` có
     *         thể có (từ 0 đến 65535).
     *         Nếu `count[val] > 0` và `(nums[k] & val) == 0`:
     *         Cộng `count[val]` vào kết quả.
     *         6. Tổng độ phức tạp: O(N^2 + N * 2^16). Với N=1000, ~ 10^6 + 6.5*10^7
     *         thao tác, đủ nhanh.
     */
    public int countTriplets(int[] nums) {
        int[] count = new int[1 << 16]; // 2^16 = 65536

        // Step 1: Precompute AND of all pairs
        for (int x : nums) {
            for (int y : nums) {
                count[x & y]++;
            }
        }

        int ans = 0;

        // Step 2: Iterate through the third number and check against pair summaries
        for (int x : nums) {
            // Iterate through all possible values of (nums[i] & nums[j])
            for (int val = 0; val < (1 << 16); val++) {
                // Optimization: Skip if no pair produced this value
                if (count[val] == 0) {
                    continue;
                }

                // If AND with third number is 0, add all contributing pairs
                if ((x & val) == 0) {
                    ans += count[val];
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] n1 = { 2, 1, 3 };
        System.out.println("Result: " + sol.countTriplets(n1)); // 12

        int[] n2 = { 0, 0, 0 };
        System.out.println("Result: " + sol.countTriplets(n2)); // 27
    }
}
