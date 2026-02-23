package leet_code.Problem_242_Easy_Valid_Anagram;

import java.util.Arrays;

public class Solution_Counter {

    /**
     * Checks if two strings are anagrams.
     * Uses an integer array to count character frequencies.
     * Time: O(N), Space: O(1) (fixed 26).
     * 
     * Kiểm tra hai chuỗi có phải là đảo chữ không.
     * Sử dụng mảng số nguyên để đếm tần số ký tự.
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        // Increment for s, decrement for t
        // Tăng cho s, giảm cho t
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // Check if all counts are zero
        // Kiểm tra nếu tất cả các đếm đều bằng 0
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_Counter solution = new Solution_Counter();

        // Test Case 1: "anagram", "nagaram" -> true
        System.out.println("Is Anagram 1: " + solution.isAnagram("anagram", "nagaram"));

        // Test Case 2: "rat", "car" -> false
        System.out.println("Is Anagram 2: " + solution.isAnagram("rat", "car"));
    }
}
