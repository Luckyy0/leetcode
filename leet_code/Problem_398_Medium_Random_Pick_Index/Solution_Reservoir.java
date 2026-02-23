package leet_code.Problem_398_Medium_Random_Pick_Index;

import java.util.Random;

public class Solution_Reservoir {

    private int[] nums;
    private Random rand;

    /**
     * Initializes the object with the array nums.
     * Uses Reservoir Sampling for O(1) space.
     * Time: O(N) per pick, Space: O(1).
     * 
     * Khởi tạo đối tượng với mảng nums.
     * Sử dụng Lấy mẫu Hồ chứa để tiết kiệm không gian O(1).
     */
    public Solution_Reservoir(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }

    /**
     * Picks a random index of target.
     */
    public int pick(int target) {
        int res = -1;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                // With probability 1/count, replace the result with i
                // Với xác suất 1/count, thay thế kết quả bằng i
                if (rand.nextInt(count) == 0) {
                    res = i;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_Reservoir solution = new Solution_Reservoir(new int[] { 1, 2, 3, 3, 3 });

        System.out.println("Pick 3: " + solution.pick(3));
        System.out.println("Pick 3: " + solution.pick(3));
        System.out.println("Pick 1: " + solution.pick(1));
    }
}
