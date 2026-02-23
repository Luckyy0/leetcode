package leet_code.Problem_139_Medium_Word_Break;

import java.util.*;

public class Solution_DP {

    /**
     * Determines if a string can be segmented into a sequence of dictionary words.
     * Uses 1D Dynamic Programming with O(N^3) time and O(N) space.
     * 
     * Xác định xem một chuỗi có thể được phân tách thành một chuỗi các từ trong từ
     * điển hay không.
     * Sử dụng Quy hoạch động 1 chiều với thời gian O(N^3) và không gian O(N).
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        // Use a Set for O(1) average lookup time
        // Sử dụng Set để có thời gian tra cứu trung bình là O(1)
        Set<String> dict = new HashSet<>(wordDict);
        int n = s.length();

        // dp[i] is true if s.substring(0, i) can be segmented
        // dp[i] là đúng nếu s.substring(0, i) có thể được phân tách
        boolean[] dp = new boolean[n + 1];

        // Base case: empty string
        // Trường hợp cơ sở: chuỗi rỗng
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // If prefix s[0...j] is valid and s[j...i] is a word
                // Nếu tiền tố s[0...j] hợp lệ và s[j...i] là một từ
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    // Optimization: break loop once i is valid
                    // Tối ưu hóa: thoát vòng lặp một khi i đã hợp lệ
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1: leetcode
        List<String> d1 = Arrays.asList("leet", "code");
        System.out.println("Test Case 1: " + solution.wordBreak("leetcode", d1));
        // Expected: true

        // Test Case 2: applepenapple
        List<String> d2 = Arrays.asList("apple", "pen");
        System.out.println("Test Case 2: " + solution.wordBreak("applepenapple", d2));
        // Expected: true

        // Test Case 3: catsandog
        List<String> d3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println("Test Case 3: " + solution.wordBreak("catsandog", d3));
        // Expected: false
    }
}
