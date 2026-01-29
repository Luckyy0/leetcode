package leetcode.P565_ArrayNesting;

class Solution {
    public int arrayNesting(int[] nums) {
        int maxLen = 0;
        int n = nums.length;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int count = 0;
                int current = i;

                // Follow the cycle
                // Theo dõi chu trình
                while (!visited[current]) {
                    visited[current] = true;
                    current = nums[current];
                    count++;
                }

                maxLen = Math.max(maxLen, count);
            }
        }

        return maxLen;
    }
}
