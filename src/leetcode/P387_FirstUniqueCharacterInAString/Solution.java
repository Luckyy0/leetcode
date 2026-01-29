package leetcode.P387_FirstUniqueCharacterInAString;

public class Solution {

    /**
     * Problem 387: First Unique Character in a String
     * Approach: Frequency Array
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int firstUniqChar(String s) {
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "leetcode" -> 0
        runTest(solution, "leetcode", 0);

        // "loveleetcode" -> 2
        runTest(solution, "loveleetcode", 2);

        // "aabb" -> -1
        runTest(solution, "aabb", -1);
    }

    private static void runTest(Solution s, String str, int expected) {
        int result = s.firstUniqChar(str);
        System.out.println("Input: " + str + " -> " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
