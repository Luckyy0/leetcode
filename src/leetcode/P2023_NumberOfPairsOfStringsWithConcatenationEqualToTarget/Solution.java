package leetcode.P2023_NumberOfPairsOfStringsWithConcatenationEqualToTarget;

public class Solution {
    public int numOfPairs(String[] nums, String target) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if ((nums[i].length() + nums[j].length() == target.length())
                            && (nums[i] + nums[j]).equals(target)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
