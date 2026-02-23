package leet_code.Problem_905_Easy_Sort_Array_By_Parity;

/**
 * Problem 905: Sort Array By Parity
 * https://leetcode.com/problems/sort-array-by-parity/
 */
public class Solution {

    /**
     * Sorts the array so that even integers are followed by odd integers.
     * Strategy: Two Pointers (In-place).
     * 
     * @param nums Array of integers.
     * @return Sorted array.
     * 
     *         Tóm tắt chiến lược:
     *         1. Sử dụng hai con trỏ `left` và `right`.
     *         2. Mục tiêu là chuyển tất cả số lẻ về bên phải và số chẵn về bên
     *         trái.
     *         3. Di chuyển `left` sang phải để bỏ qua các số chẵn (đã đúng vị trí).
     *         4. Di chuyển `right` sang trái để bỏ qua các số lẻ (đã đúng vị trí).
     *         5. Khi `left` tìm thấy số lẻ và `right` tìm thấy số chẵn, hoán đổi
     *         chúng.
     *         6. Lặp lại quá trình cho đến khi hai con trỏ gặp nhau.
     */
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // Move left pointer forward while elements are even
            while (left < right && nums[left] % 2 == 0) {
                left++;
            }

            // Move right pointer backward while elements are odd
            while (left < right && nums[right] % 2 != 0) {
                right--;
            }

            // If pointers have not crossed, swap the elements
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                // After swap, move pointers?
                // Actually, the while loops will handle the newly swapped values
                // correctly in the next iteration (checking them again is cheap/fast).
                // Or we can increment/decrement here, but just leaving it is safer.
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = { 3, 1, 2, 4 };
        int[] res1 = sol.sortArrayByParity(nums1);
        // Print array
        System.out.print("Result: ");
        for (int n : res1)
            System.out.print(n + " ");
        System.out.println(); // Expected: 4 2 1 3 (or any valid permutation)

        int[] nums2 = { 0 };
        int[] res2 = sol.sortArrayByParity(nums2);
        System.out.print("Result: ");
        for (int n : res2)
            System.out.print(n + " ");
        System.out.println(); // Expected: 0
    }
}
