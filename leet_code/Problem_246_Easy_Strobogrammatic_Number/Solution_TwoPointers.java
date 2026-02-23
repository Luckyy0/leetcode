package leet_code.Problem_246_Easy_Strobogrammatic_Number;

import java.util.HashMap;
import java.util.Map;

public class Solution_TwoPointers {

    /**
     * Checks if a number is strobogrammatic.
     * Uses Two Pointers.
     * Time: O(N), Space: O(1).
     * 
     * Kiểm tra xem một số có phải là strobogrammatic không.
     * Sử dụng Hai con trỏ.
     */
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');

        int left = 0;
        int right = num.length() - 1;

        while (left <= right) {
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);

            // If leftChar is not a valid rotatable digit, or if its rotation doesn't match
            // rightChar
            // Nếu leftChar không phải là số xoay hợp lệ, hoặc nếu xoay của nó không khớp
            // rightChar
            if (!map.containsKey(leftChar) || map.get(leftChar) != rightChar) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_TwoPointers solution = new Solution_TwoPointers();

        // Test Case 1: "69" -> true
        System.out.println("Is 69 Strobogrammatic? " + solution.isStrobogrammatic("69"));

        // Test Case 2: "88" -> true
        System.out.println("Is 88 Strobogrammatic? " + solution.isStrobogrammatic("88"));

        // Test Case 3: "962" -> false
        System.out.println("Is 962 Strobogrammatic? " + solution.isStrobogrammatic("962"));
    }
}
