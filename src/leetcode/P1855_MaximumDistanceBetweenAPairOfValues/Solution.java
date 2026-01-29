package leetcode.P1855_MaximumDistanceBetweenAPairOfValues;

public class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int maxDist = 0;

        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                if (j >= i) {
                    maxDist = Math.max(maxDist, j - i);
                }
                j++;
            } else {
                i++;
            }
        }

        return maxDist;
    }
}
