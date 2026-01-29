package leetcode.P1668_MaximumRepeatingSubstring;

public class Solution {
    public int maxRepeating(String sequence, String word) {
        int count = 0;
        StringBuilder sb = new StringBuilder(word);

        while (sequence.contains(sb)) {
            count++;
            sb.append(word);
        }

        return count;
    }
}
