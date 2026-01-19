package leetcode.P246_StrobogrammaticNumber;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * Problem 246: Strobogrammatic Number
     * Approach: Two Pointers with Mapping
     * 
     * Theoretical Basis:
     * - Match characters from outside in.
     * - Must satisfy rotational symmetry pairs: (0,0), (1,1), (8,8), (6,9), (9,6).
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
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
            char cLeft = num.charAt(left);
            char cRight = num.charAt(right);

            if (!map.containsKey(cLeft)) {
                return false;
            }

            if (map.get(cLeft) != cRight) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "69" -> true
        runTest(solution, "69", true);

        // "88" -> true
        runTest(solution, "88", true);

        // "962" -> false (2 is invalid)
        runTest(solution, "962", false);

        // "1" -> true
        runTest(solution, "1", true);

        // "6" -> false
        runTest(solution, "6", false);
    }

    private static void runTest(Solution s, String num, boolean expected) {
        boolean result = s.isStrobogrammatic(num);
        System.out.println("Input: " + num + " -> Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
