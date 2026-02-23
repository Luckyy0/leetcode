package leet_code.Problem_80_Medium_Remove_Duplicates_From_Sorted_Array_II;

import java.util.Arrays;

public class Solution_TwoPointers {

    /**
     * Removes duplicates from a sorted array such that each element appears at most
     * twice.
     * Uses two pointers approach for in-place modification.
     * Loại bỏ các phần tử trùng lặp từ một mảng đã sắp xếp sao cho mỗi phần tử xuất
     * hiện tối đa hai lần.
     * Sử dụng phương pháp hai con trỏ để sửa đổi tại chỗ.
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        // k is the index where the next valid element should be placed
        // k là chỉ số nơi phần tử hợp lệ tiếp theo sẽ được đặt
        int k = 2;

        for (int i = 2; i < nums.length; i++) {
            // Because the array is sorted, if nums[i] is different from nums[k-2],
            // it means we haven't seen this element more than twice yet.
            // Vì mảng đã được sắp xếp, nếu nums[i] khác với nums[k-2],
            // điều đó có nghĩa là chúng ta chưa thấy phần tử này quá hai lần.
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        Solution_TwoPointers solution = new Solution_TwoPointers();

        // Test Case 1
        int[] n1 = { 1, 1, 1, 2, 2, 3 };
        int k1 = solution.removeDuplicates(n1);
        System.out.println("Test Case 1: k=" + k1 + ", result=" + Arrays.toString(Arrays.copyOf(n1, k1)));
        // Expected: 5, [1, 1, 2, 2, 3]

        // Test Case 2
        int[] n2 = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
        int k2 = solution.removeDuplicates(n2);
        System.out.println("Test Case 2: k=" + k2 + ", result=" + Arrays.toString(Arrays.copyOf(n2, k2)));
        // Expected: 7, [0, 0, 1, 1, 2, 3, 3]
    }
}
