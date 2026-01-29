package leetcode.P2149_RearrangeArrayElementsBySign;

public class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int posIdx = 0;
        int negIdx = 1;

        for (int x : nums) {
            if (x > 0) {
                res[posIdx] = x;
                posIdx += 2;
            } else {
                res[negIdx] = x;
                negIdx += 2;
            }
        }

        return res;
    }
}
