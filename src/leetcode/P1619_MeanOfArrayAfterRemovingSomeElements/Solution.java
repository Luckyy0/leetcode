package leetcode.P1619_MeanOfArrayAfterRemovingSomeElements;

import java.util.Arrays;

public class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int remove = n / 20;

        long sum = 0;
        for (int i = remove; i < n - remove; i++) {
            sum += arr[i];
        }

        return (double) sum / (n - 2 * remove);
    }
}
