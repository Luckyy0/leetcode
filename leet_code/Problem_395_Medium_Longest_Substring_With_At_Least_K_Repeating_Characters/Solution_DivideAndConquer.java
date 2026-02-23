package leet_code.Problem_395_Medium_Longest_Substring_With_At_Least_K_Repeating_Characters;

public class Solution_DivideAndConquer {

    /**
     * Finds the length of the longest substring with at least k repeating
     * characters.
     * Use Divide and Conquer.
     * Time: O(N * 26), Space: O(N).
     * 
     * Tìm độ dài chuỗi con dài nhất có ít nhất k ký tự lặp lại.
     * Sử dụng phương pháp Chia để trị.
     */
    public int longestSubstring(String s, int k) {
        return helper(s, 0, s.length(), k);
    }

    private int helper(String s, int start, int end, int k) {
        if (end - start < k)
            return 0;

        int[] counts = new int[26];
        for (int i = start; i < end; i++) {
            counts[s.charAt(i) - 'a']++;
        }

        for (int i = start; i < end; i++) {
            char ch = s.charAt(i);
            if (counts[ch - 'a'] < k) {
                // This character 'ch' cannot be part of any valid result.
                // Ký tự 'ch' này không thể là phần của bất kỳ kết quả hợp lệ nào.
                int left = helper(s, start, i, k);
                int right = helper(s, i + 1, end, k);
                return Math.max(left, right);
            }
        }

        return end - start;
    }

    public static void main(String[] args) {
        Solution_DivideAndConquer solution = new Solution_DivideAndConquer();

        // Test Case 1: "aaabb", k=3 -> 3
        System.out.println("Result 1: " + solution.longestSubstring("aaabb", 3));

        // Test Case 2: "ababbc", k=2 -> 5
        System.out.println("Result 2: " + solution.longestSubstring("ababbc", 2));
    }
}
