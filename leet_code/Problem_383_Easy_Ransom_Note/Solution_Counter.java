package leet_code.Problem_383_Easy_Ransom_Note;

public class Solution_Counter {

    /**
     * Checks if ransomNote can be constructed from magazine.
     * Uses frequency counting.
     * Time: O(N + M), Space: O(1).
     * 
     * Kiểm tra xem ransomNote có thể được tạo từ magazine hay không.
     * Sử dụng đếm tần suất.
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length())
            return false;

        int[] counts = new int[26];

        // Count characters in magazine
        // Đếm các ký tự trong magazine
        for (char c : magazine.toCharArray()) {
            counts[c - 'a']++;
        }

        // Subtract characters in ransomNote
        // Trừ bớt các ký tự trong ransomNote
        for (char c : ransomNote.toCharArray()) {
            counts[c - 'a']--;
            if (counts[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_Counter solution = new Solution_Counter();

        // Test Case 1: "a", "b" -> false
        System.out.println("Result 1: " + solution.canConstruct("a", "b"));

        // Test Case 2: "aa", "aab" -> true
        System.out.println("Result 2: " + solution.canConstruct("aa", "aab"));
    }
}
