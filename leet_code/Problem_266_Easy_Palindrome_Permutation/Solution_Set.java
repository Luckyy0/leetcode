package leet_code.Problem_266_Easy_Palindrome_Permutation;

import java.util.HashSet;
import java.util.Set;

public class Solution_Set {

    /**
     * Checks if a permutation of the string can form a palindrome.
     * Uses HashSet to track characters with odd counts.
     * Time: O(N), Space: O(1) (limited to alphabet size).
     * 
     * Kiểm tra xem hoán vị của chuỗi có thể tạo thành palindrome không.
     * Sử dụng HashSet để theo dõi các ký tự có số lượng lẻ.
     */
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c); // Pair found, remove
            } else {
                set.add(c); // Unpaired, add
            }
        }
        // Valid if 0 or 1 unpaired characters remain
        // Hợp lệ nếu còn lại 0 hoặc 1 ký tự không ghép cặp
        return set.size() <= 1;
    }

    public static void main(String[] args) {
        Solution_Set solution = new Solution_Set();

        // Test Case 1: "code" -> false
        System.out.println("Can Permute 1: " + solution.canPermutePalindrome("code"));

        // Test Case 2: "aab" -> true
        System.out.println("Can Permute 2: " + solution.canPermutePalindrome("aab"));

        // Test Case 3: "carerac" -> true
        System.out.println("Can Permute 3: " + solution.canPermutePalindrome("carerac"));
    }
}
