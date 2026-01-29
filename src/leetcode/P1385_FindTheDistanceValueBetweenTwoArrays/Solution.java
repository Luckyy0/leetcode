package leetcode.P1385_FindTheDistanceValueBetweenTwoArrays;

import java.util.Arrays;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;

        for (int val : arr1) {
            if (check(arr2, val, d)) {
                count++;
            }
        }

        return count;
    }

    // Returns true if NO element in arr2 is within d of val
    private boolean check(int[] arr, int val, int d) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (Math.abs(arr[mid] - val) <= d) {
                return false; // Found one within distance
            }
            if (arr[mid] < val) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return true;
    }
}
