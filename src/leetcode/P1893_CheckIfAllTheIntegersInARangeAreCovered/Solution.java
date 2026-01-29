package leetcode.P1893_CheckIfAllTheIntegersInARangeAreCovered;

public class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean[] covered = new boolean[51];
        for (int[] r : ranges) {
            for (int i = r[0]; i <= r[1]; i++) {
                if (i <= 50)
                    covered[i] = true;
            }
        }

        for (int i = left; i <= right; i++) {
            if (!covered[i])
                return false;
        }
        return true;
    }
}
