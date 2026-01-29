package leetcode.P2182_ConstructStringWithRepeatLimit;

public class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26];
        for (char c : s.toCharArray())
            count[c - 'a']++;

        StringBuilder sb = new StringBuilder();

        int i = 25; // Pointer to largest available char
        while (i >= 0) {
            if (count[i] == 0) {
                i--;
                continue;
            }

            // Append up to limit copies of char i
            int take = Math.min(count[i], repeatLimit);
            for (int k = 0; k < take; k++)
                sb.append((char) ('a' + i));
            count[i] -= take;

            if (count[i] > 0) {
                // Need to break streak with next largest char
                int j = i - 1;
                while (j >= 0 && count[j] == 0)
                    j--;

                if (j >= 0) {
                    sb.append((char) ('a' + j));
                    count[j]--;
                    // After inserting one j, we can potentially add more i (next iteration)
                    // Do not decrement i, stay on i to finish it
                } else {
                    // No smaller char to break streak. Stop.
                    break;
                }
            } else {
                // Finished all of char i, move to next
                i--;
            }
        }

        return sb.toString();
    }
}
