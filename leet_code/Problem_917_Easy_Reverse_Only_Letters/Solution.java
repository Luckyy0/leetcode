package leet_code.Problem_917_Easy_Reverse_Only_Letters;

/**
 * Problem 917: Reverse Only Letters
 * https://leetcode.com/problems/reverse-only-letters/
 */
public class Solution {

    /**
     * Reverses the order of letters in a string, skipping other characters.
     * Strategy: Two Pointers.
     * 
     * @param s Input string.
     * @return Reversed string.
     * 
     *         Tóm tắt chiến lược:
     *         1. Sử dụng hai con trỏ `left` (đầu chuỗi) và `right` (cuối chuỗi).
     *         2. Mục tiêu là hoán đổi vị trí các chữ cái tiếng Anh mà không làm
     *         thay đổi
     *         vị trí của các ký tự khác (số, dấu, v.v.).
     *         3. Di chuyển `left` sang phải để tìm chữ cái đầu tiên.
     *         4. Di chuyển `right` sang trái để tìm chữ cái đầu tiên.
     *         5. Khi cả hai đều trỏ vào chữ cái và `left < right`:
     *         - Hoán đổi hai chữ cái.
     *         - Tiếp tục di chuyển cả hai con trỏ.
     *         6. Nếu một trong hai không phải chữ cái, chỉ di chuyển con trỏ đó.
     */
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Move left pointer forward if not a letter
            if (!Character.isLetter(chars[left])) {
                left++;
            }
            // Move right pointer backward if not a letter
            else if (!Character.isLetter(chars[right])) {
                right--;
            }
            // Both are letters, swap them
            else {
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
        Solution sol = new Solution();

        System.out.println("Result: " + sol.reverseOnlyLetters("ab-cd")); // dc-ba
        System.out.println("Result: " + sol.reverseOnlyLetters("a-bC-dEf-ghIj")); // j-Ih-gfE-dCba
        System.out.println("Result: " + sol.reverseOnlyLetters("Test1ng-Leet=code-Q!")); // Qedo1ct-eeLg=ntse-T!
    }
}
