package leet_code.Problem_167_Medium_Two_Sum_II_Input_Array_Is_Sorted;

public class Solution_TwoPointers {

    /**
     * Finds two numbers in a sorted array that add up to the target.
     * Uses Two Pointers for O(N) time and O(1) space.
     * 
     * Tìm hai số trong một mảng đã sắp xếp có tổng bằng target.
     * Sử dụng Hai con trỏ cho thời gian O(N) và không gian O(1).
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // Return 1-indexed results
                return new int[] { left + 1, right + 1 };
            } else if (sum < target) {
                // Sum too small, move left pointer to increase sum
                left++;
            } else {
                // Sum too large, move right pointer to decrease sum
                right--;
            }
        }

        // According to problem constraints, a solution always exists.
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        Solution_TwoPointers solution = new Solution_TwoPointers();

        // Test Case 1: [2,7,11,15], target 9
        int[] result1 = solution.twoSum(new int[] { 2, 7, 11, 15 }, 9);
        System.out.println("Result 1: [" + result1[0] + ", " + result1[1] + "]");

        // Test Case 2: [2,3,4], target 6
        int[] result2 = solution.twoSum(new int[] { 2, 3, 4 }, 6);
        System.out.println("Result 2: [" + result2[0] + ", " + result2[1] + "]");
    }
}
