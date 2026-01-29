package leetcode.P484_FindPermutation;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 484: Find Permutation
     * Approach: Sorted array with segment reversal for 'D' patterns
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int[] findPermutation(String s) {
        int n = s.length() + 1;
        int[] res = new int[n];
        for (int i = 0; i < n; i++)
            res[i] = i + 1;

        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'D') {
                int l = i;
                while (i < s.length() && s.charAt(i) == 'D') {
                    i++;
                }
                // Reverse res[l...i]
                reverse(res, l, i);
            } else {
                i++;
            }
        }

        return res;
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // "DI" -> [2, 1, 3]
        System.out.println("Result 1: " + Arrays.toString(sol.findPermutation("DI")));

        // "ID" -> [1, 3, 2]
        System.out.println("Result 2: " + Arrays.toString(sol.findPermutation("ID")));

        // "DD" -> [3, 2, 1]
        System.out.println("Result 3: " + Arrays.toString(sol.findPermutation("DD")));
    }
}
