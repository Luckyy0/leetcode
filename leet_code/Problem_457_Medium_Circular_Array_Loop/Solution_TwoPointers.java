package leet_code.Problem_457_Medium_Circular_Array_Loop;

public class Solution_TwoPointers {

    /**
     * Detects if there's a uni-directional circular loop of length > 1.
     * Strategy: Fast/Slow pointers (Floyd's algorithm).
     * Time: O(N), Space: O(1).
     */
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // If already visited and failed, skip
            if (nums[i] == 0)
                continue;

            int slow = i;
            int fast = i;
            boolean isForward = nums[i] > 0;

            // Cycle detection
            while (true) {
                slow = getNext(nums, slow, isForward);
                if (slow == -1)
                    break; // Direction change or self-loop

                fast = getNext(nums, fast, isForward);
                if (fast == -1)
                    break;
                fast = getNext(nums, fast, isForward);
                if (fast == -1)
                    break;

                if (slow == fast)
                    return true;
            }

            // Optimization: Mark path as invalid (not implemented here for simplicity,
            // but can be done by setting traversed nums[idx] = 0)
        }

        return false;
    }

    /**
     * Finds next index. Returns -1 if direction changes or it's a self-loop (length
     * 1).
     */
    private int getNext(int[] nums, int curr, boolean isForward) {
        int n = nums.length;
        boolean currForward = nums[curr] > 0;

        // Direction change?
        if (currForward != isForward)
            return -1;

        int next = (curr + nums[curr]) % n;
        if (next < 0)
            next += n;

        // Self loop?
        if (next == curr)
            return -1;

        return next;
    }

    public static void main(String[] args) {
        Solution_TwoPointers solution = new Solution_TwoPointers();
        int[] nums1 = { 2, -1, 1, 2, 2 };
        System.out.println("Result 1: " + solution.circularArrayLoop(nums1)); // true

        int[] nums2 = { -1, 2 };
        System.out.println("Result 2: " + solution.circularArrayLoop(nums2)); // false
    }
}
