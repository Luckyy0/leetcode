package leet_code.Problem_496_Easy_Next_Greater_Element_I;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution_MonotonicStack {

    /**
     * Finds next greater element for subset.
     * Strategy: Monotonic stack on nums2 to build map.
     * Time: O(N + M), Space: O(M) where M is length of nums2.
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_MonotonicStack solution = new Solution_MonotonicStack();
        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };
        int[] res = solution.nextGreaterElement(nums1, nums2);

        System.out.print("Result: [");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + (i < res.length - 1 ? ", " : ""));
        }
        System.out.println("]"); // [-1, 3, -1]
    }
}
