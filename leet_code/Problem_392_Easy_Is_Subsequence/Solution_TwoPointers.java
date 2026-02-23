package leet_code.Problem_392_Easy_Is_Subsequence;

public class Solution_TwoPointers {

    /**
     * Checks if s is a subsequence of t.
     * Uses two pointers approach.
     * Time: O(T), Space: O(1).
     * 
     * Kiểm tra xem s có phải là chuỗi con của t không.
     * Sử dụng phương pháp hai con trỏ.
     */
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0)
            return true;
        if (t == null || t.length() == 0)
            return false;

        int i = 0; // pointer for s
        int j = 0; // pointer for t

        while (j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                // If we found all characters of s, return true
                if (i == s.length()) {
                    return true;
                }
            }
            j++;
        }

        return i == s.length();
    }

    public static void main(String[] args) {
        Solution_TwoPointers solution = new Solution_TwoPointers();

        // Test Case 1: "abc", "ahbgdc" -> true
        System.out.println("Result 1: " + solution.isSubsequence("abc", "ahbgdc"));

        // Test Case 2: "axc", "ahbgdc" -> false
        System.out.println("Result 2: " + solution.isSubsequence("axc", "ahbgdc"));
    }
}
