package leetcode.P768_MaxChunksToMakeSortedII;

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] minRight = new int[n];
        minRight[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(minRight[i + 1], arr[i]);
        }

        int chunks = 1;
        int maxLeft = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            maxLeft = Math.max(maxLeft, arr[i]);
            if (maxLeft <= minRight[i + 1]) {
                chunks++;
            }
        }
        return chunks;
    }
}
