package leet_code.Problem_922_Easy_Sort_Array_By_Parity_II;

/**
 * Problem 922: Sort Array By Parity II
 * https://leetcode.com/problems/sort-array-by-parity-ii/
 */
public class Solution {

    /**
     * Sorts the array so that even indices have even numbers and odd indices have
     * odd numbers.
     * Strategy: In-Place Swap.
     * 
     * @param nums Input array of even length.
     * @return Sorted array.
     * 
     *         Tóm tắt chiến lược:
     *         1. Ta muốn tất cả các vị trí chẵn (0, 2, 4...) chứa số chẵn,
     *         và tất cả các vị trí lẻ (1, 3, 5...) chứa số lẻ.
     *         2. Sử dụng hai con trỏ:
     *         - `i` chạy trên các chỉ số chẵn.
     *         - `j` chạy trên các chỉ số lẻ.
     *         3. Duyệt `i` từ 0, bước nhảy 2:
     *         - Nếu `nums[i]` là số chẵn -> đúng vị trí -> bỏ qua.
     *         - Nếu `nums[i]` là số lẻ -> sai vị trí.
     *         4. Khi `nums[i]` sai, ta cần tìm một số chẵn đang nằm sai ở vị trí lẻ
     *         `j` để đổi chỗ.
     *         - Tăng `j` cho đến khi tìm thấy `nums[j]` là chẵn (sai vị trí).
     *         5. Hoán đổi `nums[i]` và `nums[j]`.
     *         6. Lặp lại cho đến khi hết mảng.
     */
    public int[] sortArrayByParityII(int[] nums) {
        int i = 0; // Even index pointer
        int j = 1; // Odd index pointer
        int n = nums.length;

        while (i < n && j < n) {
            // While even index has even number, it's correct. Move to next even index.
            while (i < n && nums[i] % 2 == 0) {
                i += 2;
            }

            // While odd index has odd number, it's correct. Move to next odd index.
            while (j < n && nums[j] % 2 == 1) {
                j += 2;
            }

            // If pointers are within bounds, swap the misplaced elements
            if (i < n && j < n) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                // After swap, current nums[i] is even and nums[j] is odd (correct).
                // We'll move pointers in the next iteration or the inner loops.
                // It's safe to manually increment here too, but the loops handle it.
                i += 2;
                j += 2;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] res1 = sol.sortArrayByParityII(new int[] { 4, 2, 5, 7 });
        System.out.print("Result: ");
        for (int x : res1)
            System.out.print(x + " "); // Example: 4 5 2 7
        System.out.println();

        int[] res2 = sol.sortArrayByParityII(new int[] { 2, 3 });
        System.out.print("Result: ");
        for (int x : res2)
            System.out.print(x + " "); // 2 3
        System.out.println();
    }
}
