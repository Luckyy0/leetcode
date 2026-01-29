package leetcode.P1754_LargestMergeOfTwoStrings;

public class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder merge = new StringBuilder();
        int i = 0, j = 0;
        int n = word1.length(), m = word2.length();

        while (i < n && j < m) {
            // Compare suffixes
            if (word1.substring(i).compareTo(word2.substring(j)) > 0) {
                merge.append(word1.charAt(i));
                i++;
            } else {
                merge.append(word2.charAt(j));
                j++;
            }
        }

        if (i < n)
            merge.append(word1.substring(i));
        if (j < m)
            merge.append(word2.substring(j));

        return merge.toString();
    }
}
