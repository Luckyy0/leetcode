package leetcode.P845_LongestMountainInArray;

class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int maxLen = 0;

        for (int i = 1; i < n - 1; i++) {
            // Check for peak
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                while (left > 0 && arr[left - 1] < arr[left]) {
                    left--;
                }

                int right = i + 1;
                while (right < n - 1 && arr[right + 1] < arr[right]) {
                    right++;
                }

                maxLen = Math.max(maxLen, right - left + 1);
                i = right; // Skip already processed part
            }
        }

        return maxLen;
    }
}
