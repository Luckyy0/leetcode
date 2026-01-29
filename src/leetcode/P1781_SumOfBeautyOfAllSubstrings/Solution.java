package leetcode.P1781_SumOfBeautyOfAllSubstrings;

public class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int totalBeauty = 0;

        for (int i = 0; i < n; i++) {
            int[] counts = new int[26];
            for (int j = i; j < n; j++) {
                counts[s.charAt(j) - 'a']++;

                int max = 0;
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 26; k++) {
                    if (counts[k] > 0) {
                        max = Math.max(max, counts[k]);
                        min = Math.min(min, counts[k]);
                    }
                }

                totalBeauty += (max - min);
            }
        }

        return totalBeauty;
    }
}
