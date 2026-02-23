package leet_code.Problem_632_Hard_Smallest_Range_Covering_Elements_from_K_Lists;

import java.util.*;

public class Solution_Heap {

    private class Node {
        int val;
        int row;
        int col;

        Node(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

    /**
     * Finds the smallest range covering elements from K lists.
     * Strategy: Min-Heap with current representatives and tracking global max.
     * Time: O(N log K), Space: O(K).
     */
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        int maxVal = Integer.MIN_VALUE;
        // Step 1: Initialize heap with the first element of each list
        for (int i = 0; i < k; i++) {
            int val = nums.get(i).get(0);
            minHeap.offer(new Node(val, i, 0));
            maxVal = Math.max(maxVal, val);
        }

        int start = 0, end = Integer.MAX_VALUE;

        // Step 2: Extract min and push next element from the same list
        while (minHeap.size() == k) {
            Node minNode = minHeap.poll();

            // Update global best range
            if (maxVal - minNode.val < end - start) {
                start = minNode.val;
                end = maxVal;
            }

            // Check if there's a next element in the current list
            if (minNode.col + 1 < nums.get(minNode.row).size()) {
                int nextVal = nums.get(minNode.row).get(minNode.col + 1);
                minHeap.offer(new Node(nextVal, minNode.row, minNode.col + 1));
                maxVal = Math.max(maxVal, nextVal);
            } else {
                // If any list is exhausted, we cannot form a range covering all lists anymore
                break;
            }
        }

        return new int[] { start, end };
    }

    public static void main(String[] args) {
        Solution_Heap sol = new Solution_Heap();
        List<List<Integer>> nums = Arrays.asList(
                Arrays.asList(4, 10, 15, 24, 26),
                Arrays.asList(0, 9, 12, 20),
                Arrays.asList(5, 18, 22, 30));
        int[] result = sol.smallestRange(nums);
        System.out.println("Result: [" + result[0] + ", " + result[1] + "]"); // [20, 24]
    }
}
