package leet_code.Problem_88_Easy_Merge_Sorted_Array;

import java.util.Arrays;

public class Solution_ThreePointers {

    /**
     * Merges nums2 into nums1 in non-decreasing order.
     * Starts from the end to achieve O(1) space complexity.
     * Hợp nhất nums2 vào nums1 theo thứ tự không giảm.
     * Bắt đầu từ cuối để đạt được độ phức tạp không gian O(1).
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        // Iterate through nums2
        // Duyệt qua mảng nums2
        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                // Move element from nums1 to the end
                // Di chuyển phần tử từ nums1 về cuối
                nums1[p] = nums1[p1];
                p1--;
            } else {
                // Move element from nums2 to the end
                // Di chuyển phần tử từ nums2 về cuối
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
    }

    public static void main(String[] args) {
        Solution_ThreePointers solution = new Solution_ThreePointers();

        // Test Case 1: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        int[] n1_1 = { 1, 2, 3, 0, 0, 0 };
        int[] n2_1 = { 2, 5, 6 };
        solution.merge(n1_1, 3, n2_1, 3);
        System.out.println("Test Case 1: " + Arrays.toString(n1_1));
        // Expected: [1, 2, 2, 3, 5, 6]

        // Test Case 2: nums1 = [1], m = 1, nums2 = [], n = 0
        int[] n1_2 = { 1 };
        int[] n2_2 = {};
        solution.merge(n1_2, 1, n2_2, 0);
        System.out.println("Test Case 2: " + Arrays.toString(n1_2));
        // Expected: [1]

        // Test Case 3: nums1 = [0], m = 0, nums2 = [1], n = 1
        int[] n1_3 = { 0 };
        int[] n2_3 = { 1 };
        solution.merge(n1_3, 0, n2_3, 1);
        System.out.println("Test Case 3: " + Arrays.toString(n1_3));
        // Expected: [1]
    }
}
