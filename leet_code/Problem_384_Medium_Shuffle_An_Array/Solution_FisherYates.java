package leet_code.Problem_384_Medium_Shuffle_An_Array;

import java.util.Random;

public class Solution_FisherYates {

    private int[] original;
    private int[] array;
    private Random rand;

    /**
     * Initializes the object with the integer array nums.
     * Uses Fisher-Yates algorithm for uniform shuffle.
     * Time: O(N) for shuffle, Space: O(N).
     * 
     * Khởi tạo đối tượng với mảng số nguyên nums.
     * Sử dụng thuật toán Fisher-Yates để tráo đổi đồng nhất.
     */
    public Solution_FisherYates(int[] nums) {
        original = nums.clone();
        array = nums;
        rand = new Random();
    }

    /**
     * Resets the array to its original configuration and returns it.
     */
    public int[] reset() {
        array = original.clone();
        return array;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        for (int i = array.length - 1; i > 0; i--) {
            // Pick a random index between 0 and i inclusive
            // Chọn một chỉ số ngẫu nhiên từ 0 đến i (bao gồm cả i)
            int j = rand.nextInt(i + 1);
            swap(i, j);
        }
        return array;
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Solution_FisherYates solution = new Solution_FisherYates(new int[] { 1, 2, 3 });

        printArray(solution.shuffle());
        printArray(solution.reset());
        printArray(solution.shuffle());
    }

    private static void printArray(int[] a) {
        for (int i : a)
            System.out.print(i + " ");
        System.out.println();
    }
}
