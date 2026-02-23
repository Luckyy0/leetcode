package leet_code.Problem_330_Hard_Patching_Array;

public class Solution_Greedy {

    /**
     * Finds min patches to cover range [1, n].
     * Uses Greedy approach tracking the missing sum.
     * Time: O(M + log N), Space: O(1).
     * 
     * Tìm số bản vá tối thiểu để bao phủ phạm vi [1, n].
     * Sử dụng phương pháp Tham lam theo dõi tổng còn thiếu.
     */
    public int minPatches(int[] nums, int n) {
        long miss = 1; // Smallest sum in [1, n] that we cannot form
        int patches = 0;
        int i = 0;

        while (miss <= n) {
            // If we have a number in array that can help cover 'miss'
            // Nếu chúng ta có một số trong mảng có thể giúp bao phủ 'miss'
            // That number must be <= miss. If it is, we extend range to [1, miss + nums[i])
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                // Otherwise we must patch.
                // Best patch is 'miss' itself, doubling range.
                // Ngược lại chúng ta phải vá.
                // Bản vá tốt nhất chính là 'miss', nhân đôi phạm vi.
                miss += miss;
                patches++;
            }
        }

        return patches;
    }

    public static void main(String[] args) {
        Solution_Greedy solution = new Solution_Greedy();

        // Test Case 1: [1,3], n=6 -> 1
        int[] n1 = { 1, 3 };
        System.out.println("Patches 1: " + solution.minPatches(n1, 6));

        // Test Case 2: [1,5,10], n=20 -> 2
        int[] n2 = { 1, 5, 10 };
        System.out.println("Patches 2: " + solution.minPatches(n2, 20));

        // Test Case 3: [1,2,2], n=5 -> 0
        int[] n3 = { 1, 2, 2 };
        System.out.println("Patches 3: " + solution.minPatches(n3, 5));
    }
}
