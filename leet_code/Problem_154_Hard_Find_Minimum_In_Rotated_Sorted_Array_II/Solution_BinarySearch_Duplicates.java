package leet_code.Problem_154_Hard_Find_Minimum_In_Rotated_Sorted_Array_II;

public class Solution_BinarySearch_Duplicates {

    /**
     * Finds the minimum element in a rotated sorted array with duplicates.
     * Time: O(log N) average, O(N) worst case.
     * Space: O(1).
     * 
     * Tìm phần tử nhỏ nhất trong mảng đã sắp xếp bị xoay có các phần tử trùng lặp.
     * Thời gian: Trung bình O(log N), Trường hợp xấu nhất O(N).
     * Không gian: O(1).
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum is in the right half
                // Giá trị nhỏ nhất nằm ở nửa bên phải
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                // Minimum is in the left half (including mid)
                // Giá trị nhỏ nhất nằm ở nửa bên trái (bao gồm cả mid)
                right = mid;
            } else {
                // Ambiguous case: nums[mid] == nums[right]
                // We only know that right is duplicate, so shrink only by one
                // Trường hợp mơ hồ: không chắc chắn nửa nào, thu hẹp dần từ bên phải
                right--;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        Solution_BinarySearch_Duplicates solution = new Solution_BinarySearch_Duplicates();

        // Test Case 1: [1,3,5] -> 1
        int[] n1 = { 1, 3, 5 };
        System.out.println("Test Case 1: " + solution.findMin(n1));

        // Test Case 2: [2,2,2,0,1] -> 0
        int[] n2 = { 2, 2, 2, 0, 1 };
        System.out.println("Test Case 2: " + solution.findMin(n2));

        // Test Case 3: [1, 1, 1, 0, 1] -> 0
        int[] n3 = { 1, 1, 1, 0, 1 };
        System.out.println("Test Case 3: " + solution.findMin(n3));
    }
}
