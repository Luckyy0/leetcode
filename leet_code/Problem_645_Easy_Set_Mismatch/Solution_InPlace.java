package leet_code.Problem_645_Easy_Set_Mismatch;

public class Solution_InPlace {

    /**
     * Finds the duplicate and missing numbers in an array from 1 to n.
     * Strategy: Use the array itself as a hash table by negating values at indices.
     * Time: O(N), Space: O(1).
     */
    public int[] findErrorNums(int[] nums) {
        int duplicate = -1;
        int missing = -1;

        // Phase 1: Identify the duplicate by marking visited indices as negative
        for (int n : nums) {
            int val = Math.abs(n);
            if (nums[val - 1] < 0) {
                // We've already flipped this index, so 'val' is the duplicate
                duplicate = val;
            } else {
                nums[val - 1] *= -1;
            }
        }

        // Phase 2: Identify the missing by finding the only remaining positive index
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
            }
        }

        return new int[] { duplicate, missing };
    }

    public static void main(String[] args) {
        Solution_InPlace sol = new Solution_InPlace();
        int[] result = sol.findErrorNums(new int[] { 1, 2, 2, 4 });
        System.out.println("Duplicate: " + result[0] + ", Missing: " + result[1]); // 2, 3
    }
}
