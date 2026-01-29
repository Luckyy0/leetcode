package leetcode.P1673_FindTheMostCompetitiveSubsequence;

public class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        int[] stack = new int[k];
        int top = -1; // index of top element

        for (int i = 0; i < n; i++) {
            // While we can pop and current is smaller
            // remaining elements: n - 1 - i
            // elements in stack: top + 1
            // total potential length if we keep stack: top + 1 + n - i
            // We need length >= k.
            // If we pop, stack size becomes top. Pot length: top + n - i.
            // So while stack not empty AND current < topVal AND (top + n - i >= k)
            // Wait, logic: Can we pop? Yes if (k - (top + 1)) < (remaining_in_nums).
            // i.e., elements needed < elements available.

            while (top >= 0 && nums[i] < stack[top] && (top + 1 + (n - 1 - i) >= k)) {
                top--;
            }

            if (top < k - 1) {
                stack[++top] = nums[i];
            }
        }

        return stack;
    }
}
