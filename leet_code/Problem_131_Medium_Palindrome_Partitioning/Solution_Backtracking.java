package leet_code.Problem_131_Medium_Palindrome_Partitioning;

import java.util.*;

public class Solution_Backtracking {

    /**
     * Finds all possible palindrome partitioning of the string s.
     * Uses backtracking and dynamic programming for efficiency.
     * 
     * Tìm tất cả các phép phân tách chuỗi đối xứng của s.
     * Sử dụng quay lui và quy hoạch động để đạt hiệu quả cao.
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        int n = s.length();

        // dp[i][j] is true if s[i...j] is a palindrome
        // dp[i][j] là đúng nếu s[i...j] là một chuỗi đối xứng
        boolean[][] dp = new boolean[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len <= 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        backtrack(s, 0, new ArrayList<>(), result, dp);
        return result;
    }

    private void backtrack(String s, int start, List<String> currentList,
            List<List<String>> result, boolean[][] dp) {
        // Base case: we reached the end of the string
        // Trường hợp cơ sở: chúng ta đã đi đến cuối chuỗi
        if (start == s.length()) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            // If current substring is a palindrome
            // Nếu chuỗi con hiện tại là đối xứng
            if (dp[start][end]) {
                // Add to current path
                // Thêm vào con đường hiện tại
                currentList.add(s.substring(start, end + 1));

                // Recursively call for the rest of the string
                // Gọi đệ quy cho phần còn lại của chuỗi
                backtrack(s, end + 1, currentList, result, dp);

                // Remove from current path (backtrack)
                // Xóa khỏi con đường hiện tại (quay lui)
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution_Backtracking solution = new Solution_Backtracking();

        // Test Case 1: "aab"
        System.out.println("Test Case 1: " + solution.partition("aab"));
        // Expected: [[a, a, b], [aa, b]]

        // Test Case 2: "a"
        System.out.println("Test Case 2: " + solution.partition("a"));
        // Expected: [[a]]
    }
}
