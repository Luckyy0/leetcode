package leetcode.P561_ArrayPartition;

import java.util.Arrays;

class Solution {
    public int arrayPairSum(int[] nums) {
        // Sort the array to pair smallest numbers together
        // Sắp xếp mảng để ghép các số nhỏ nhất lại với nhau
        Arrays.sort(nums);

        int sum = 0;
        // Sum up every other element starting from index 0
        // Cộng tổng mọi phần tử khác bắt đầu từ chỉ số 0
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }
}
