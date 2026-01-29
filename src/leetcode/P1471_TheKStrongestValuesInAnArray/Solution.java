package leetcode.P1471_TheKStrongestValuesInAnArray;

import java.util.Arrays;

class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int m = arr[(n - 1) / 2];

        int[] res = new int[k];
        int l = 0, r = n - 1;
        int idx = 0;

        while (idx < k) {
            int dl = Math.abs(arr[l] - m);
            int dr = Math.abs(arr[r] - m);

            if (dl > dr) {
                res[idx++] = arr[l++];
            } else if (dr > dl) {
                res[idx++] = arr[r--];
            } else {
                // Same diff, but arr[r] >= arr[l] because sorted
                res[idx++] = arr[r--];
            }
        }

        return res;
    }
}
