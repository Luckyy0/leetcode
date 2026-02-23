package leet_code.Problem_4_Hard_Median_Of_Two_Sorted_Arrays;

public class Solution_BinarySearch {

    /**
     * Finds the median of two sorted arrays using Binary SearchPartition.
     * Time Complexity: O(log(min(m, n))).
     * Tìm trung vị của hai mảng đã sắp xếp sử dụng Tìm kiếm Nhị phân Phân hoạch.
     * Độ phức tạp thời gian: O(log(min(m, n))).
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to minimize binary search range
        // Đảm bảo nums1 là mảng nhỏ hơn để giảm thiểu phạm vi tìm kiếm nhị phân
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0;
        int high = m;

        while (low <= high) {
            // Partition positions
            // Vị trí phân hoạch
            int partitionX = (low + high) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;

            // Edge handling: if partition is at 0, use -INF; if at length, use +INF
            // Xử lý biên: nếu phân hoạch ở 0, dùng -INF; nếu ở cuối độ dài, dùng +INF
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

            // Check if we found the correct partition
            // Kiểm tra xem chúng ta đã tìm thấy phân hoạch đúng chưa
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // If total length is even
                // Nếu tổng độ dài là chẵn
                if ((m + n) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                }
                // If total length is odd
                // Nếu tổng độ dài là lẻ
                else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            }
            // If maxLeftX is too big, move to the left side
            // Nếu maxLeftX quá lớn, di chuyển sang phía bên trái
            else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            }
            // If maxLeftY is too big, move to the right side
            // Nếu maxLeftY quá lớn, di chuyển sang phía bên phải
            else {
                low = partitionX + 1;
            }
        }

        // Only here if input is invalid (not sorted, etc.)
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_BinarySearch solution = new Solution_BinarySearch();

        // Test Case 1
        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2 };
        System.out.println("Test Case 1: " + solution.findMedianSortedArrays(nums1, nums2));
        // Expected: 2.0

        // Test Case 2
        int[] nums1b = { 1, 2 };
        int[] nums2b = { 3, 4 };
        System.out.println("Test Case 2: " + solution.findMedianSortedArrays(nums1b, nums2b));
        // Expected: 2.5

        // Test Case 3: Empty array check
        int[] nums1c = {};
        int[] nums2c = { 1 };
        System.out.println("Test Case 3: " + solution.findMedianSortedArrays(nums1c, nums2c));
        // Expected: 1.0

        // Test Case 4: Larger example
        int[] nums1d = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] nums2d = { 1, 2, 3, 4, 5 };
        // Merged: 1,1,2,2,3,3,4,4,5,5,6,7,8 (13 el) -> 7th el is 4
        System.out.println("Test Case 4: " + solution.findMedianSortedArrays(nums1d, nums2d));
        // Expected: 4.0
    }
}
