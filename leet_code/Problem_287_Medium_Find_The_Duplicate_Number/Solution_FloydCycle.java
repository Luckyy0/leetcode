package leet_code.Problem_287_Medium_Find_The_Duplicate_Number;

public class Solution_FloydCycle {

    /**
     * Finds the duplicate number.
     * Uses Floyd's Cycle Detection (Tortoise and Hare).
     * Time: O(N), Space: O(1).
     * Do not modify the array.
     * 
     * Tìm số trùng lặp.
     * Sử dụng Phát hiện Chu trình Floyd (Rùa và Thỏ).
     */
    public int findDuplicate(int[] nums) {
        // Phase 1: Finding the intersection point of the two runners.
        // Giai đoạn 1: Tìm giao điểm của hai con chạy.
        int tortoise = nums[0];
        int hare = nums[0];

        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Phase 2: Finding the "entrance" to the cycle.
        // Giai đoạn 2: Tìm "lối vào" của chu trình.
        tortoise = nums[0]; // Reset one ptr to start

        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }

    public static void main(String[] args) {
        Solution_FloydCycle solution = new Solution_FloydCycle();

        // Test Case 1: [1,3,4,2,2] -> 2
        int[] n1 = { 1, 3, 4, 2, 2 };
        System.out.println("Duplicate 1: " + solution.findDuplicate(n1));

        // Test Case 2: [3,1,3,4,2] -> 3
        int[] n2 = { 3, 1, 3, 4, 2 };
        System.out.println("Duplicate 2: " + solution.findDuplicate(n2));
    }
}
