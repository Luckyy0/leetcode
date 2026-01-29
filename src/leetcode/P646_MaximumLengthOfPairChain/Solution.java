package leetcode.P646_MaximumLengthOfPairChain;

import java.util.Arrays;

class Solution {
    public int findLongestChain(int[][] pairs) {
        // Sort pairs by their end time
        // Sắp xếp các cặp theo thời gian kết thúc của chúng
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        int currEnd = Integer.MIN_VALUE;
        int count = 0;

        for (int[] pair : pairs) {
            if (pair[0] > currEnd) {
                count++;
                currEnd = pair[1];
            }
        }

        return count;
    }
}
