package leetcode.P1300_SumOfMutatedArrayClosestToTarget;

class Solution {
    public int findBestValue(int[] arr, int target) {
        int max = 0;
        for (int x : arr)
            max = Math.max(max, x);

        int left = 0, right = max;
        // Binary search to find transition point or exact value
        while (left < right) {
            int mid = left + (right - left) / 2;
            int s = getSum(arr, mid);
            if (s < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // left is the first value where sum >= target
        int v1 = left;
        int v2 = left - 1;

        int sum1 = getSum(arr, v1);
        int sum2 = getSum(arr, v2);

        // Compare distances
        if (Math.abs(sum1 - target) < Math.abs(sum2 - target))
            return v1;
        else
            return v2;
    }

    private int getSum(int[] arr, int v) {
        int sum = 0;
        for (int x : arr) {
            sum += Math.min(x, v);
        }
        return sum;
    }
}
