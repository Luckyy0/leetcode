package leetcode.P985_SumOfEvenNumbersAfterQueries;

class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0;
        for (int x : nums) {
            if (x % 2 == 0)
                sum += x;
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int idx = queries[i][1];

            if (nums[idx] % 2 == 0)
                sum -= nums[idx];
            nums[idx] += val;
            if (nums[idx] % 2 == 0)
                sum += nums[idx];

            res[i] = sum;
        }

        return res;
    }
}
