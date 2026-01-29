package leetcode.P1794_CountPairsOfEqualSubstringsWithMinimumDifference;

public class Solution {
    public int countQuadruples(String firstString, String secondString) {
        int[] firstLast = new int[26];
        int[] secondFirst = new int[26];

        for (int i = 0; i < 26; i++) {
            firstLast[i] = -1;
            secondFirst[i] = -1;
        }

        for (int i = 0; i < firstString.length(); i++) {
            firstLast[firstString.charAt(i) - 'a'] = i;
        }

        // We want smallest j for second string, so iterate forward and store first
        // occurrence
        for (int j = 0; j < secondString.length(); j++) {
            int c = secondString.charAt(j) - 'a';
            if (secondFirst[c] == -1) {
                secondFirst[c] = j;
            }
        }

        int minDiff = Integer.MAX_VALUE;
        int count = 0;

        for (int c = 0; c < 26; c++) {
            if (firstLast[c] != -1 && secondFirst[c] != -1) {
                int diff = secondFirst[c] - firstLast[c];
                if (diff < minDiff) {
                    minDiff = diff;
                    count = 1;
                } else if (diff == minDiff) {
                    count++;
                }
            }
        }

        return count;
    }
}
