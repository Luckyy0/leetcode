package leet_code.Problem_41_Hard_First_Missing_Positive;

public class Solution_CyclicSort {

    /**
     * Finds the smallest missing positive integer.
     * Uses the Cyclic Sort (Index Hashing) approach.
     * Tìm số nguyên dương nhỏ nhất còn thiếu.
     * Sử dụng phương pháp Sắp xếp Vòng lặp.
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Cyclic sort to place numbers in their correct indices
        // Bước 1: Sắp xếp vòng lặp để đưa các số về đúng chỉ số của chúng
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with nums[nums[i] - 1]
                int targetIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[targetIndex];
                nums[targetIndex] = temp;
            }
        }

        // Step 2: Find the first missing positive
        // Bước 2: Tìm số dương đầu tiên bị thiếu
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // Step 3: If all are present, return n + 1
        // Bước 3: Nếu tất cả đều có mặt, trả về n + 1
        return n + 1;
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_CyclicSort solution = new Solution_CyclicSort();

        // Test Case 1
        int[] nums1 = { 1, 2, 0 };
        System.out.println("Test Case 1: " + solution.firstMissingPositive(nums1));
        // Expected: 3

        // Test Case 2
        int[] nums2 = { 3, 4, -1, 1 };
        System.out.println("Test Case 2: " + solution.firstMissingPositive(nums2));
        // Expected: 2

        // Test Case 3
        int[] nums3 = { 7, 8, 9, 11, 12 };
        System.out.println("Test Case 3: " + solution.firstMissingPositive(nums3));
        // Expected: 1
    }
}
