package leet_code.Problem_408_Easy_Valid_Word_Abbreviation;

public class Solution_TwoPointers {

    /**
     * Determines if abbr is a valid abbreviation of word.
     * Uses two pointers approach with digit parsing.
     * Time: O(N), Space: O(1).
     * 
     * Xác định xem abbr có phải là từ viết tắt hợp lệ của word không.
     * Sử dụng phương pháp hai con trỏ với việc phân tích chữ số.
     */
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        int wordLen = word.length();
        int abbrLen = abbr.length();

        while (i < wordLen && j < abbrLen) {
            char c = abbr.charAt(j);

            if (Character.isDigit(c)) {
                // Leading zero check
                // Kiểm tra số 0 ở đầu
                if (c == '0')
                    return false;

                // Parse number
                // Phân tích số
                int num = 0;
                while (j < abbrLen && Character.isDigit(abbr.charAt(j))) {
                    num = num * 10 + (abbr.charAt(j) - '0');
                    j++;
                }

                // Skip num characters in word
                // Bỏ qua num ký tự trong word
                i += num;
            } else {
                // Character match check
                // Kiểm tra khớp ký tự
                if (word.charAt(i) != abbr.charAt(j)) {
                    return false;
                }
                i++;
                j++;
            }
        }

        return i == wordLen && j == abbrLen;
    }

    public static void main(String[] args) {
        Solution_TwoPointers solution = new Solution_TwoPointers();

        // Test Case 1: "internationalization", "i12iz4n" -> true
        System.out.println("Result 1: " + solution.validWordAbbreviation("internationalization", "i12iz4n"));

        // Test Case 2: "apple", "a2e" -> false
        System.out.println("Result 2: " + solution.validWordAbbreviation("apple", "a2e"));
    }
}
