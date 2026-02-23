package leet_code.Problem_974_Medium_Subarray_Sums_Divisible_by_K;

/**
 * Problem 974: Subarray Sums Divisible by K
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/
 */
public class Solution {

    /**
     * Finds the number of subarrays divisible by k.
     * Strategy: Prefix Sum with Modulo counting.
     * 
     * @param nums Array of integers.
     * @param k    The divisor.
     * @return Number of subarrays.
     * 
     *         Tóm tắt chiến lược:
     *         1. Sử dụng tính chất của phép đồng dư: `(Sum[j] - Sum[i]) % K == 0`
     *         khi và chỉ khi `Sum[j] % K == Sum[i] % K`.
     *         2. Ta tính tổng tiền tố `prefixSum` tại mỗi bước.
     *         3. Tính số dư `rem = prefixSum % K`.
     *         Lưu ý: Trong Java, số dư của số âm có thể âm (ví dụ -2 % 5 = -2).
     *         Để chuẩn hóa về đoạn [0, K-1], ta dùng `(rem % K + K) % K`.
     *         4. Sử dụng mảng `count` kích thước `K` để đếm số lần xuất hiện của
     *         từng số dư `rem` đã gặp trước đó.
     *         5. Khởi tạo `count[0] = 1` để tính cả trường hợp mảng con bắt đầu từ
     *         đầu mảng (hiệu với tổng tiền tố rỗng = 0).
     *         6. Tại mỗi bước, cộng `count[rem]` vào kết quả `result` (số lượng cặp
     *         `(Sum[j], Sum[i])` thoả mãn).
     *         Sau đó tăng `count[rem]` lên 1.
     */
    public int subarraysDivByK(int[] nums, int k) {
        // Frequency array for remainders
        int[] count = new int[k];

        // Base case: prefix sum of 0 has remainder 0. This occurs once (before
        // iterating).
        count[0] = 1;

        int prefixSum = 0;
        int result = 0;

        for (int num : nums) {
            prefixSum += num;

            // Calculate remainder.
            // Be careful with negative numbers.
            // Formula: (a % k + k) % k ensures result is in [0, k-1]
            int remainder = (prefixSum % k + k) % k;

            // If this remainder has been seen before, it means there are subarrays ending
            // here
            // that are divisible by K. The number of such subarrays is equal to the count
            // of this remainder so far.
            result += count[remainder];

            // Increment the count for this remainder
            count[remainder]++;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] n1 = { 4, 5, 0, -2, -3, 1 };
        System.out.println("Result: " + sol.subarraysDivByK(n1, 5)); // 7

        int[] n2 = { 5 };
        System.out.println("Result: " + sol.subarraysDivByK(n2, 9)); // 0
    }
}
