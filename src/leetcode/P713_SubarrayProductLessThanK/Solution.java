package leetcode.P713_SubarrayProductLessThanK;

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;

        int count = 0;
        int product = 1;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            // Shrink window if product is too large
            // Thu hẹp cửa sổ nếu tích quá lớn
            while (product >= k) {
                product /= nums[left++];
            }

            // All subarrays ending at right and starting from left..right are valid
            // Tất cả các mảng con kết thúc tại right và bắt đầu từ left..right đều hợp lệ
            count += (right - left + 1);
        }

        return count;
    }
}
