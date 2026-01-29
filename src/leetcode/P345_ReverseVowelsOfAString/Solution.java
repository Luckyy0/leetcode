package leetcode.P345_ReverseVowelsOfAString;

public class Solution {

    /**
     * Problem 345: Reverse Vowels of a String
     * Approach: Two Pointers
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N) (Output string/array)
     */
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0)
            return s;

        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            while (left < right && !isVowel(chars[left])) {
                left++;
            }
            while (left < right && !isVowel(chars[right])) {
                right--;
            }

            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }

        return new String(chars);
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "hello" -> "holle"
        runTest(solution, "hello", "holle");

        // "leetcode" -> "leotcede"
        runTest(solution, "leetcode", "leotcede");

        // "aA" -> "Aa"
        runTest(solution, "aA", "Aa");
    }

    private static void runTest(Solution s, String input, String expected) {
        String result = s.reverseVowels(input);
        System.out.println("Input: " + input + " -> " + result + " (Expected: " + expected + ")");
        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
