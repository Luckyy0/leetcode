package leetcode.P384_ShuffleAnArray;

import java.util.Arrays;
import java.util.Random;

public class Solution {

    /**
     * Problem 384: Shuffle an Array
     * Approach: Fisher-Yates Shuffle
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    private int[] array;
    private int[] original;
    private Random rand;

    public Solution(int[] nums) {
        this.array = nums;
        this.original = nums.clone();
        this.rand = new Random();
    }

    public int[] reset() {
        array = original.clone();
        return array;
    }

    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            int j = rand.nextInt(array.length - i) + i; // Random index from i to n-1
            swap(array, i, j);
        }
        return array;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        Solution solution = new Solution(nums);

        System.out.println("Shuffle: " + Arrays.toString(solution.shuffle()));
        System.out.println("Reset: " + Arrays.toString(solution.reset()));
        System.out.println("Shuffle: " + Arrays.toString(solution.shuffle()));
    }
}
