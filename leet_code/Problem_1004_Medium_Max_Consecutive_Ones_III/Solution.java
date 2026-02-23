package leet_code.Problem_1004_Medium_Max_Consecutive_Ones_III;

/**
 * Problem 1004: Max Consecutive Ones III
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 */
public class Solution {

    /**
     * Finds the maximum number of consecutive 1s after flipping at most k 0s using
     * a sliding window approach.
     * Strategy: Sliding Window / Two Pointers.
     * 
     * @param nums The binary array.
     * @param k    The maximum number of 0s that can be flipped.
     * @return The maximum number of consecutive 1s.
     * 
     *         Tóm tắt chiến lược:
     *         1. Bài toán yêu cầu tìm dãy con dài nhất chứa toàn số 1, với quyền
     *         thay đổi tối đa `k` số 0. Nói cách khác, tìm dãy con dài nhất chứa
     *         nhiều nhất `k` số 0.
     *         2. Chắc chắn sử dụng "Cửa sổ trượt" (Sliding Window).
     *         3. Dùng 2 con trỏ `left` và `right` để duy trì cửa sổ trượt
     *         `[left, right]`.
     *         4. Duyệt mảng bằng con trỏ `right`. Nếu gặp phần tử 0, ta tăng
     *         biến đếm `zeros` lên 1.
     *         5. Nếu số lượng số 0 vượt mức cho phép (`zeros > k`), cửa sổ lúc
     *         này đã không hợp lệ. Ta cần dịch chuyển con trỏ `left` sang phải để
     *         loại bỏ dần các phần tử khỏi cửa sổ. Trong quá trình đó, nếu phần
     *         tử loại bỏ là 0, ta giảm biến `zeros`. Dừng dịch `left` khi `zeros <=
     *         k`.
     *         6. Liên tục cập nhật chiều dài cửa sổ trượt dài nhất là `right - left
     *         + 1`.
     */
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeros = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            // Include nums[right] into the window
            if (nums[right] == 0) {
                zeros++;
            }

            // Shrink the window if it's invalid
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            // Update the maximum length found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k1 = 2;
        System.out.println("Result 1: " + sol.longestOnes(nums1, k1)); // expected 6

        int[] nums2 = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
        int k2 = 3;
        System.out.println("Result 2: " + sol.longestOnes(nums2, k2)); // expected 10
    }
}
