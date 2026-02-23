package leet_code.Problem_828_Hard_Count_Unique_Characters_of_All_Substrings;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Calculates the total sum of unique character counts for all substrings.
     * Strategy: For each character, calculate the number of substrings in which it
     * is unique.
     * A character at index i is unique in substring [L+1, R-1]
     * where L is the previous index of the same char and R is the next index of the
     * same char.
     * Time: O(N), Space: O(N).
     */
    public int uniqueLetterString(String s) {
        int n = s.length();
        long mod = 1_000_000_007;

        // Store positions of each character 'A'..'Z'
        List<Integer>[] posList = new List[26];
        for (int i = 0; i < 26; i++) {
            posList[i] = new ArrayList<>();
            // Add initial sentinel
            posList[i].add(-1);
        }

        for (int i = 0; i < n; i++) {
            posList[s.charAt(i) - 'A'].add(i);
        }

        // Add final sentinel
        for (int i = 0; i < 26; i++) {
            posList[i].add(n);
        }

        long totalResult = 0;

        // For each letter, iterate through its occurrences
        for (int i = 0; i < 26; i++) {
            for (int j = 1; j < posList[i].size() - 1; j++) {
                int prevPos = posList[i].get(j - 1);
                int currPos = posList[i].get(j);
                int nextPos = posList[i].get(j + 1);

                // Number of substrings starting between (prevPos+1) and currPos
                // AND ending between currPos and (nextPos-1)
                long contribution = (long) (currPos - prevPos) * (nextPos - currPos);
                totalResult = (totalResult + contribution) % mod;
            }
        }

        return (int) totalResult;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1: " + sol.uniqueLetterString("ABC")); // 10
        System.out.println("Result 2: " + sol.uniqueLetterString("ABA")); // 8
    }
}
