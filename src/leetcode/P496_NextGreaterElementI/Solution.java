package leetcode.P496_NextGreaterElementI;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    /**
     * Problem 496: Next Greater Element I
     * Approach: Monotonic Stack with Map lookup
     * 
     * Time Complexity: O(M + N) where M=nums1.length, N=nums2.length
     * Space Complexity: O(N)
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // num -> nextGreater
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
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
        Solution sol = new Solution();

        // nums1 = [4,1,2], nums2 = [1,3,4,2] -> [-1,3,-1]
        int[] n1 = { 4, 1, 2 };
        int[] n2 = { 1, 3, 4, 2 };
        System.out.println("Result 1: " + java.util.Arrays.toString(sol.nextGreaterElement(n1, n2)));

        // nums1 = [2,4], nums2 = [1,2,3,4] -> [3,-1]
        int[] n3 = { 2, 4 };
        int[] n4 = { 1, 2, 3, 4 };
        System.out.println("Result 2: " + java.util.Arrays.toString(sol.nextGreaterElement(n3, n4)));
    }
}
