package leetcode.P1574_ShortestSubarrayToBeRemovedToMakeArraySorted;

public class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        // Find longest non-decreasing prefix
        int left = 0;
        while (left + 1 < n && arr[left] <= arr[left + 1]) {
            left++;
        }

        // If whole array is sorted
        if (left == n - 1)
            return 0;

        // Find longest non-decreasing suffix
        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }

        // Initial answer: remove suffix after left OR remove prefix before right
        int ans = Math.min(n - 1 - left, right);

        // Try to merge prefix and suffix
        int i = 0;
        int j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                ans = Math.min(ans, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return ans;
    }
}
