package leet_code.Problem_768_Hard_Max_Chunks_To_Make_Sorted_II;

public class Solution {

    /**
     * Finds max chunks to sort the array.
     * Strategy: Iterate and check if Max(Left) <= Min(Right).
     * Time: O(N), Space: O(N).
     */
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return 0;

        // Use long to handle potentially large values (though constraints say 10^8 int
        // is fine)
        // int is sufficient.
        int[] minRight = new int[n];
        minRight[n - 1] = arr[n - 1];

        // Precompute minimum of the right suffix
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(arr[i], minRight[i + 1]);
        }

        int chunks = 0;
        int maxLeft = Integer.MIN_VALUE;

        // Identify valid cut points
        for (int i = 0; i < n - 1; i++) {
            maxLeft = Math.max(maxLeft, arr[i]);

            // If all elements to left are smaller/equal to all elements to right
            // partition is valid here.
            if (maxLeft <= minRight[i + 1]) {
                chunks++;
            }
        }

        return chunks + 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = { 5, 4, 3, 2, 1 };
        System.out.println("Result 1: " + sol.maxChunksToSorted(arr1)); // 1

        int[] arr2 = { 2, 1, 3, 4, 4 };
        System.out.println("Result 2: " + sol.maxChunksToSorted(arr2)); // 4
    }
}
