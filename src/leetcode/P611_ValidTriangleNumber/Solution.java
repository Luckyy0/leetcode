package leetcode.P611_ValidTriangleNumber;

import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;

        // Iterate for the longest side c backwards
        // Lặp lại cho cạnh dài nhất c ngược lại
        for (int k = n - 1; k >= 2; k--) {
            int c = nums[k];
            int left = 0;
            int right = k - 1;

            while (left < right) {
                if (nums[left] + nums[right] > c) {
                    // Valid triangles can be formed with (left, right), (left+1, right)...(right-1,
                    // right)
                    // Các tam giác hợp lệ có thể được hình thành với ...
                    // Since nums[left] + nums[right] > c, and nums[x] >= nums[left] for x > left,
                    // any pair (x, right) works.
                    count += (right - left);
                    right--;
                } else {
                    // Sum is too small, need larger number
                    // Tổng quá nhỏ, cần số lớn hơn
                    left++;
                }
            }
        }

        return count;
    }
}
