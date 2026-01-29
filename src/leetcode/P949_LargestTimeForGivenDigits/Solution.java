package leetcode.P949_LargestTimeForGivenDigits;

class Solution {
    public String largestTimeFromDigits(int[] arr) {
        int maxTime = -1;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j)
                    continue;
                for (int k = 0; k < 4; k++) {
                    if (i == k || j == k)
                        continue;
                    int l = 6 - i - j - k;

                    int h = arr[i] * 10 + arr[j];
                    int m = arr[k] * 10 + arr[l];

                    if (h < 24 && m < 60) {
                        maxTime = Math.max(maxTime, h * 60 + m);
                    }
                }
            }
        }

        if (maxTime == -1)
            return "";
        return String.format("%02d:%02d", maxTime / 60, maxTime % 60);
    }
}
