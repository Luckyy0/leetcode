package leetcode.P540_SingleElementInSortedArray;

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Ensure mid is even for easy comparison
            // Đảm bảo mid là số chẵn để dễ so sánh
            if (mid % 2 == 1) {
                mid--;
            }

            // If the pair matches, the single element is to the right
            // Nếu cặp khớp, phần tử duy nhất ở bên phải
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                // If not, the single element is here or to the left
                // Nếu không, phần tử duy nhất ở đây hoặc bên trái
                right = mid;
            }
        }

        return nums[left];
    }
}
