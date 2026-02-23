package leet_code.Problem_345_Easy_Reverse_Vowels_Of_A_String;

public class Solution_TwoPointers {

    /**
     * Reverses only vowels in the string.
     * Uses Two Pointers.
     * Time: O(N), Space: O(N) (due to Java string immutability).
     * 
     * Chỉ đảo ngược các nguyên âm trong chuỗi.
     * Sử dụng Hai Con trỏ.
     */
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0)
            return s;

        char[] chars = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            // Move left pointer until it points to a vowel
            while (left < right && vowels.indexOf(chars[left]) == -1) {
                left++;
            }

            // Move right pointer until it points to a vowel
            while (left < right && vowels.indexOf(chars[right]) == -1) {
                right--;
            }

            // Swap if they are still within bounds
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

    public static void main(String[] args) {
        Solution_TwoPointers solution = new Solution_TwoPointers();

        // Test Case 1: "hello" -> "holle"
        System.out.println("Result 1: " + solution.reverseVowels("hello"));

        // Test Case 2: "leetcode" -> "leotcede"
        System.out.println("Result 2: " + solution.reverseVowels("leetcode"));
    }
}
