package leetcode.P2019_TheScoreOfStudentsSolvingMathExpressions;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public int scoreOfStudents(String s, int[] answers) {
        int n = s.length(); // e.g. "3+5*2" len 5.
        // Convert to numbers and ops or treat directly.
        // N is odd. (n+1)/2 numbers.
        int numCount = (n + 1) / 2;

        // Calculate correct
        int correct = evalCorrect(s);

        // DP for all possible
        // dp[i][j] stores possible values for numbers indices from i to j (0-based
        // numbers)
        // number index k corresponds to s char index 2*k
        @SuppressWarnings("unchecked")
        Set<Integer>[][] dp = new Set[numCount][numCount];

        for (int i = 0; i < numCount; i++) {
            dp[i][i] = new HashSet<>();
            dp[i][i].add(s.charAt(2 * i) - '0');
        }

        for (int len = 2; len <= numCount; len++) {
            for (int i = 0; i <= numCount - len; i++) {
                int j = i + len - 1;
                dp[i][j] = new HashSet<>();

                // Split at op index k (op between number k and k+1)
                // Operator index in s is 2*k + 1
                // k goes from i to j-1
                for (int k = i; k < j; k++) {
                    char op = s.charAt(2 * k + 1);
                    Set<Integer> left = dp[i][k];
                    Set<Integer> right = dp[k + 1][j];

                    if (left.isEmpty() || right.isEmpty())
                        continue;

                    for (int l : left) {
                        for (int r : right) {
                            int val = 0;
                            if (op == '+')
                                val = l + r;
                            else
                                val = l * r;

                            if (val <= 1000) {
                                dp[i][j].add(val);
                            }
                        }
                    }
                }
            }
        }

        Set<Integer> possible = dp[0][numCount - 1];
        int totalScore = 0;

        for (int ans : answers) {
            if (ans == correct) {
                totalScore += 5;
            } else if (possible.contains(ans)) {
                totalScore += 2;
            }
        }

        return totalScore;
    }

    private int evalCorrect(String s) {
        Stack<Integer> nums = new Stack<>();
        char lastOp = '+';
        int curr = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                curr = c - '0';
            }
            if (!Character.isDigit(c) || i == s.length() - 1) {
                if (lastOp == '+')
                    nums.push(curr);
                else if (lastOp == '*')
                    nums.push(nums.pop() * curr);

                lastOp = c;
                curr = 0;
            }
        }

        int res = 0;
        for (int x : nums)
            res += x;
        return res;
    }
}
