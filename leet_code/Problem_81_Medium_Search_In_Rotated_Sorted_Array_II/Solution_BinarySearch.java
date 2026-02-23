package leet_code.Problem_81_Medium_Search_In_Rotated_Sorted_Array_II;

public class Solution_BinarySearch {

    /**
     * Searches for a target in a rotated sorted array that may contain duplicates.
     * Uses a specialized binary search to handle duplicates.
     * Tìm kiếm giá trị mục tiêu trong mảng đã sắp xếp bị xoay có thể chứa các phần
     * tử trùng lặp.
     * Sử dụng tìm kiếm nhị phân chuyên biệt để xử lý các phần tử trùng lặp.
     */
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // Handle the case where low, mid, and high are the same
            // Xử lý trường hợp low, mid, và high đều giống nhau
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
            }
            // Left half is sorted
            // Nửa bên trái đã được sắp xếp
            else if (nums[low] <= nums[mid]) {
                // Target is within the left sorted half
                // Target nằm trong nửa bên trái đã sắp xếp
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half is sorted
            // Nửa bên phải đã được sắp xếp
            else {
                // Target is within the right sorted half
                // Target nằm trong nửa bên phải đã sắp xếp
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_BinarySearch solution = new Solution_BinarySearch();

        // Test Case 1
        int[] n1 = { 2, 5, 6, 0, 0, 1, 2 };
        System.out.println("Test Case 1: " + solution.search(n1, 0));
        // Expected: true

        // Test Case 2
        System.out.println("Test Case 2: " + solution.search(n1, 3));
        // Expected: false

        // Test Case 3 (All elements same except target)
        int[] n3 = { 1, 0, 1, 1, 1 };
        System.out.println("Test Case 3: " + solution.search(n3, 0));
        // Expected: true
    }
}
