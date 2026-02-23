package leet_code.Problem_769_Medium_Max_Chunks_To_Make_Sorted;

public class Solution {

    /**
     * Finds max chunks for permutation array.
     * Strategy: Check if max so far equals current index.
     * Time: O(N), Space: O(1).
     */
    public int maxChunksToSorted(int[] arr) {
        int chunks = 0;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            // If the maximum value seen so far is equal to the current index,
            // it means all numbers 0...i are present in arr[0...i].
            // Thus we can split here.
            if (max == i) {
                chunks++;
            }
        }

        return chunks;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = { 4, 3, 2, 1, 0 };
        System.out.println("Result 1: " + sol.maxChunksToSorted(arr1)); // 1

        int[] arr2 = { 1, 0, 2, 3, 4 };
        System.out.println("Result 2: " + sol.maxChunksToSorted(arr2)); // 4
    }
}
