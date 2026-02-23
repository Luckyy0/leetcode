package leet_code.Problem_33_Medium_Search_In_Rotated_Sorted_Array;

public class Solution_BinarySearch {

    /**
     * Searches for target in rotated sorted array.
     * Uses Modified Binary Search.
     * Tìm kiếm target trong mảng đã sắp xếp xoay.
     * Sử dụng Tìm kiếm Nhị phân Sửa đổi.
     */
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            // Kiểm tra xem nửa trái có được sắp xếp không
            if (nums[low] <= nums[mid]) {
                // If target is in the range of the left half
                // Nếu target nằm trong phạm vi của nửa trái
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Otherwise, the right half is sorted
            // Ngược lại, nửa phải được sắp xếp
            else {
                // If target is in the range of the right half
                // Nếu target nằm trong phạm vi của nửa phải
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_BinarySearch solution = new Solution_BinarySearch();

        // Test Case 1
        int[] n1 = { 4, 5, 6, 7, 0, 1, 2 };
        int t1 = 0;
        System.out.println("Test Case 1: " + solution.search(n1, t1));
        // Expected: 4

        // Test Case 2
        int[] n2 = { 4, 5, 6, 7, 0, 1, 2 };
        int t2 = 3;
        System.out.println("Test Case 2: " + solution.search(n2, t2));
        // Expected: -1

        // Test Case 3
        int[] n3 = { 1 };
        int t3 = 0;
        System.out.println("Test Case 3: " + solution.search(n3, t3));
        // Expected: -1
    }
}
