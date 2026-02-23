package leet_code.Problem_360_Medium_Sort_Transformed_Array;

import java.util.Arrays;

public class Solution_TwoPointers {

    /**
     * Transforms and sorts the array in O(N).
     * Uses Two Pointers based on the leading coefficient 'a'.
     * Time: O(N), Space: O(N).
     * 
     * Biến đổi và sắp xếp mảng trong O(N).
     * Sử dụng Hai con trỏ dựa trên hệ số dẫn đầu 'a'.
     */
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0, j = n - 1;

        // If a >= 0, largest values are at the ends
        // If a < 0, smallest values are at the ends
        int p = (a >= 0) ? n - 1 : 0;

        while (i <= j) {
            int val1 = transform(nums[i], a, b, c);
            int val2 = transform(nums[j], a, b, c);

            if (a >= 0) {
                if (val1 >= val2) {
                    res[p--] = val1;
                    i++;
                } else {
                    res[p--] = val2;
                    j--;
                }
            } else {
                if (val1 <= val2) {
                    res[p++] = val1;
                    i++;
                } else {
                    res[p++] = val2;
                    j--;
                }
            }
        }

        return res;
    }

    private int transform(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }

    public static void main(String[] args) {
        Solution_TwoPointers solution = new Solution_TwoPointers();

        // Test Case 1: nums = [-4,-2,2,4], a = 1, b = 3, c = 5 -> [3,9,15,33]
        int[] res1 = solution.sortTransformedArray(new int[] { -4, -2, 2, 4 }, 1, 3, 5);
        System.out.println("Result 1: " + Arrays.toString(res1));

        // Test Case 2: nums = [-4,-2,2,4], a = -1, b = 3, c = 5 -> [-23,-5,1,7]
        int[] res2 = solution.sortTransformedArray(new int[] { -4, -2, 2, 4 }, -1, 3, 5);
        System.out.println("Result 2: " + Arrays.toString(res2));
    }
}
