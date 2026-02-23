package leet_code.Problem_995_Hard_Minimum_Number_of_K_Consecutive_Bit_Flips;

/**
 * Problem 995: Minimum Number of K Consecutive Bit Flips
 * https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/
 */
public class Solution {

    /**
     * Calculates minimum number of k-bit flips to make binary array all 1s.
     * Strategy: Greedy + Sliding Window Tracker (Difference Array).
     * 
     * @param nums Binary array.
     * @param k    Length of consecutive flip.
     * @return Minimum flips, or -1 if impossible.
     * 
     *         Tóm tắt chiến lược:
     *         1. Thuật toán Tham lam (Greedy): Ta duyệt mảng từ trái sang phải.
     *         Bất cứ khi nào gặp số 0, ta BẮT BUỘC phải lật k phần tử tiếp theo bắt
     *         đầu từ vị trí đó.
     *         Vì nếu không lật ngay bây giờ, các vị trí phía sau không thể nào sửa
     *         được số 0 này mà không làm hỏng các phần tử khác.
     *         2. Mô phỏng ngây thơ: Gặp mảng 10^5, lật k=10^5 phần tử phía sau sẽ
     *         mất O(N*K) thao tác (khoảng 10^10) -> Quá thời gian (TLE).
     *         3. Thay vì lật thật sự K phần tử, ta chỉ "ghi nhớ" rằng CÓ MỘT THAO
     *         TÁC LẬT BẮT ĐẦU từ vị trí `i`.
     *         Và thao tác lật này sẽ kéo dài hiệu lực cho đến vị trí `i + k - 1`.
     *         4. Ta dùng thẻ `isFlipped[]` để đánh dấu những vị trí *bắt đầu* lật.
     *         Và một bộ đếm `flipCount` (hoặc `currentFlipState` 0/1) để biết phần
     *         tử hiện tại `nums[i]` đang trong vùng ảnh hưởng của *bao nhiêu* thao
     *         tác lật.
     *         5. Khi đến vị trí `i`, ta kiểm tra xem thao tác lật bắt đầu từ `i -
     *         k` đã hết hạn chưa.
     *         Nếu rồi, ta cập nhật lại `currentFlipState` bằng phép XOR:
     *         `currentFlipState ^= isFlipped[i - k]`.
     *         6. Tính trạng thái THỰC SỰ của `nums[i]`:
     *         Nếu `nums[i] == currentFlipState` (tương đương `nums[i] ^
     *         currentFlipState == 0`), nghĩa là phần tử hiện tại đang mang giá trị
     *         0.
     *         Điều đó đồng nghĩa ta BẮT BUỘC phải lật tại `i`.
     *         - Nếu `i + k > N`, không đủ chỗ lật k phần tử, trả về -1.
     *         - Đánh dấu đã lật: `isFlipped[i] = 1`, đảo trạng thái:
     *         `currentFlipState ^= 1`, tăng biến đếm tổng lượt lật.
     */
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] isFlipped = new int[n]; // Tracks where a flip was STARTED
        int currentFlipState = 0; // Represents whether the current index is flipped (1) or not (0)
        int totalFlips = 0;

        for (int i = 0; i < n; i++) {
            // Step 1: Remove effect from expired flips
            // If i is at least k, the flip that started at i - k is no longer affecting
            // index i
            if (i >= k) {
                // If there was a flip started at i-k, it will toggle the current state back
                currentFlipState ^= isFlipped[i - k];
            }

            // Step 2: Determine actual value of nums[i]
            // If nums[i] same as currentFlipState, the actual value effectively becomes 0
            // Because: nums[i] XOR currentFlipState == 0.
            // When actual value is 0, we MUST flip.
            if (nums[i] == currentFlipState) {
                // Not enough room to flip k elements
                if (i + k > n) {
                    return -1;
                }

                // Record the new flip
                isFlipped[i] = 1;
                currentFlipState ^= 1; // Toggle the state
                totalFlips++;
            }
        }

        return totalFlips;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = { 0, 1, 0 };
        System.out.println("Result 1: " + sol.minKBitFlips(nums1, 1)); // 2

        int[] nums2 = { 1, 1, 0 };
        System.out.println("Result 2: " + sol.minKBitFlips(nums2, 2)); // -1

        int[] nums3 = { 0, 0, 0, 1, 0, 1, 1, 0 };
        System.out.println("Result 3: " + sol.minKBitFlips(nums3, 3)); // 3
    }
}
