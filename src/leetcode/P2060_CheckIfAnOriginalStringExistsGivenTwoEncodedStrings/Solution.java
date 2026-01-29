package leetcode.P2060_CheckIfAnOriginalStringExistsGivenTwoEncodedStrings;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    Boolean[][][] memo;
    int offset = 1000;

    public boolean possiblyEquals(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        memo = new Boolean[n1 + 1][n2 + 1][2001];
        return solve(s1, s2, 0, 0, 0);
    }

    private boolean solve(String s1, String s2, int i, int j, int diff) {
        if (i == s1.length() && j == s2.length()) {
            return diff == 0;
        }

        if (memo[i][j][diff + offset] != null) {
            return memo[i][j][diff + offset];
        }

        // Logic:
        // If diff > 0, we have pending length from s1. Need to cover with s2.
        // If diff < 0, we have pending length from s2. Need to cover with s1.
        // If diff == 0, need cover both.

        boolean res = false;

        // Try to process digits first if at start of digits?
        // Or handle naturally.

        // If diff > 0, try to advance j
        if (diff > 0) {
            if (j < s2.length()) {
                char c = s2.charAt(j);
                if (Character.isDigit(c)) {
                    // Try all digit parses
                    int val = 0;
                    for (int k = 0; k < 3 && j + k < s2.length(); k++) {
                        char d = s2.charAt(j + k);
                        if (!Character.isDigit(d))
                            break;
                        val = val * 10 + (d - '0');
                        if (solve(s1, s2, i, j + k + 1, diff - val)) {
                            res = true;
                            break;
                        }
                    }
                } else {
                    // Match 1 wildcard
                    if (solve(s1, s2, i, j + 1, diff - 1))
                        res = true;
                }
            } else {
                // j finished, diff > 0. Fail.
                res = false;
            }
        }
        // If diff < 0, try to advance i
        else if (diff < 0) {
            if (i < s1.length()) {
                char c = s1.charAt(i);
                if (Character.isDigit(c)) {
                    int val = 0;
                    for (int k = 0; k < 3 && i + k < s1.length(); k++) {
                        char d = s1.charAt(i + k);
                        if (!Character.isDigit(d))
                            break;
                        val = val * 10 + (d - '0');
                        if (solve(s1, s2, i + k + 1, j, diff + val)) {
                            res = true;
                            break;
                        }
                    }
                } else {
                    if (solve(s1, s2, i + 1, j, diff + 1))
                        res = true;
                }
            } else {
                res = false;
            }
        }
        // diff == 0, try both
        else {
            if (i < s1.length()) {
                char c1 = s1.charAt(i);
                if (Character.isDigit(c1)) {
                    int val = 0;
                    for (int k = 0; k < 3 && i + k < s1.length(); k++) {
                        char d = s1.charAt(i + k);
                        if (!Character.isDigit(d))
                            break;
                        val = val * 10 + (d - '0');
                        if (solve(s1, s2, i + k + 1, j, diff + val)) {
                            res = true;
                            break;
                        }
                    }
                } else if (j < s2.length()) {
                    char c2 = s2.charAt(j);
                    if (Character.isDigit(c2)) {
                        int val = 0;
                        for (int k = 0; k < 3 && j + k < s2.length(); k++) {
                            char d = s2.charAt(j + k);
                            if (!Character.isDigit(d))
                                break;
                            val = val * 10 + (d - '0');
                            if (solve(s1, s2, i, j + k + 1, diff - val)) {
                                res = true;
                                break;
                            }
                        }
                    } else {
                        // Both letters
                        if (c1 == c2) {
                            if (solve(s1, s2, i + 1, j + 1, 0))
                                res = true;
                        }
                    }
                }
            }
        }

        memo[i][j][diff + offset] = res;
        return res;
    }
}
