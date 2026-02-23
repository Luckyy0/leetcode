package leet_code.Problem_415_Easy_Add_Strings;

public class Solution_StringAdd {

    /**
     * Adds two large numbers given as strings.
     * Use manual column addition simulation.
     * Time: O(N), Space: O(N).
     * 
     * Cộng hai số lớn dạng chuỗi.
     * Mô phỏng phép cộng cột thủ công.
     */
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int x = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int y = (j >= 0) ? num2.charAt(j) - '0' : 0;

            int sum = x + y + carry;
            sb.append(sum % 10);
            carry = sum / 10;

            i--;
            j--;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution_StringAdd solution = new Solution_StringAdd();

        // Test Case 1: 11 + 123 -> 134
        System.out.println("Result 11+123: " + solution.addStrings("11", "123"));

        // Test Case 2: 456 + 77 -> 533
        System.out.println("Result 456+77: " + solution.addStrings("456", "77"));
    }
}
