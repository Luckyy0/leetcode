package leet_code.Problem_992_Hard_Subarrays_with_K_Different_Integers;

/**
 * Problem 992: Subarrays with K Different Integers
 * https://leetcode.com/problems/subarrays-with-k-different-integers/
 */
public class Solution {

    /**
     * Finds the number of subarrays with exactly K different integers.
     * Strategy: Sliding Window Trick `Exact(K) = AtMost(K) - AtMost(K - 1)`.
     * 
     * @param nums Array of integers.
     * @param k    Target number of distinct integers.
     * @return Number of good subarrays.
     * 
     *         Tóm tắt chiến lược:
     *         1. Tìm số lượng mảng con liên tiếp ĐÚNG (Exactly) `K` phần tử khác
     *         nhau rất khó với Sliding Window một bước, vì khi cửa sổ co lại, ta
     *         không thể biết được bao nhiêu mảng con thỏa mãn nằm gọn bên trong.
     *         2. Giải pháp là biến đổi bài toán:
     *         `Exactly(K) = AtMost(K) - AtMost(K - 1)`
     *         Số mảng con chứa CHÍNH XÁC K phần tử khác nhau sẽ bằng số mảng con
     *         chứa TỐI ĐA K phần tử trừ đi số mảng con chứa TỐI ĐA K-1 phần tử.
     *         3. Hàm `atMost(nums, K)` dùng cửa sổ trượt (Sliding Window / Two
     *         Pointers).
     *         - Ta duy trì cửa sổ `[left, right]`.
     *         - Dùng mảng đếm tần suất (`freq`) để theo dõi các phần tử trong cửa
     *         sổ. Nếu một phần tử xuất hiện lần đầu tiên, tăng biến đếm số lượng
     *         phần tử khác nhau (`distinct`).
     *         - Nếu `distinct > K`, cửa sổ đã vượt quá giới hạn. Ta phải thu hẹp
     *         bằng cách dịch con trỏ `left` sang phải cho đến khi `distinct <= K`.
     *         Nhớ cập nhật lại mảng `freq`.
     *         - Khi cửa sổ `[left, right]` hợp lệ (có không quá K phần tử khác
     *         nhau), số lượng mảng con KẾT THÚC tại `right` và THỎA MÃN điều kiện
     *         chính là chiều dài cửa sổ: `right - left + 1`. Cộng dồn số này vào
     *         tổng số.
     */
    public int subarraysWithKDistinct(int[] nums, int k) {
        // The difference gives the exact count
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    /**
     * Calculates the number of subarrays with at most `k` distinct integers.
     */
    private int atMost(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }

        int n = nums.length;
        // Since 1 <= nums[i] <= nums.length, frequency array size is n + 1
        int[] freq = new int[n + 1];
        int count = 0;
        int left = 0;
        int distinctCount = 0;

        for (int right = 0; right < n; right++) {
            // Include right element in the window
            if (freq[nums[right]] == 0) {
                // It's a new distinct element
                distinctCount++;
            }
            freq[nums[right]]++;

            // If the window has more than k distinct elements, shrink from the left
            while (distinctCount > k) {
                freq[nums[left]]--;
                if (freq[nums[left]] == 0) {
                    // One distinct element completely left the window
                    distinctCount--;
                }
                left++;
            }

            // All subarrays that end at `right` and start somewhere from `left` to `right`
            // have AT MOST `k` distinct integers.
            // For a valid window [left, right], there are exactly (right - left + 1) such
            // subarrays.
            count += (right - left + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = { 1, 2, 1, 2, 3 };
        int k1 = 2;
        System.out.println("Result 1: " + sol.subarraysWithKDistinct(nums1, k1)); // 7

        int[] nums2 = { 1, 2, 1, 3, 4 };
        int k2 = 3;
        System.out.println("Result 2: " + sol.subarraysWithKDistinct(nums2, k2)); // 3
    }
}
