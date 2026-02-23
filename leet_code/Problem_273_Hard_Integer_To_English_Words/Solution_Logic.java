package leet_code.Problem_273_Hard_Integer_To_English_Words;

public class Solution_Logic {

    private final String[] LESS_THAN_20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
            "Nineteen" };
    private final String[] TENS = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety" };
    private final String[] THOUSANDS = { "", "Thousand", "Million", "Billion" };

    /**
     * Converts a non-negative integer to its English words representation.
     * Uses recursive helper for chunks of 1000.
     * Time: O(1) (Fixed number of digits), Space: O(1).
     * 
     * Chuyển đổi số nguyên không âm sang biểu diễn từ tiếng Anh.
     * Sử dụng hàm bổ trợ đệ quy cho các khối 1000.
     */
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        int i = 0;
        String words = "";

        while (num > 0) {
            int chunk = num % 1000;
            if (chunk != 0) {
                // Prepend the new chunk + its suffix (Thousand, Million...)
                // Chèn khối mới + hậu tố của nó vào đầu
                words = helper(chunk) + THOUSANDS[i] + " " + words;
            }
            num /= 1000;
            i++;
        }

        return words.trim();
    }

    private String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return LESS_THAN_20[num] + " ";
        } else if (num < 100) {
            return TENS[num / 10] + " " + helper(num % 10);
        } else {
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
        }
    }

    public static void main(String[] args) {
        Solution_Logic solution = new Solution_Logic();

        // Test Case 1: 123 -> "One Hundred Twenty Three"
        System.out.println("Words 1: " + solution.numberToWords(123));

        // Test Case 2: 12345 -> "Twelve Thousand Three Hundred Forty Five"
        System.out.println("Words 2: " + solution.numberToWords(12345));
    }
}
