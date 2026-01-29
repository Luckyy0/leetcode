package leetcode.P678_ValidParenthesisString;

class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0; // Minimum possible open left parentheses
        int maxOpen = 0; // Maximum possible open left parentheses

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else { // c == '*'
                minOpen--; // Treated as ')'
                maxOpen++; // Treated as '('
            }

            // If even at our most optimistic, we have more ')' than '(', it's invalid
            // Nếu ngay cả khi lạc quan nhất, chúng ta vẫn có nhiều ')' hơn '(', nó không
            // hợp lệ
            if (maxOpen < 0)
                return false;

            // minOpen cannot be negative since we can choose '*' or ignore excess '('
            // minOpen không thể là số âm vì chúng ta có thể chọn '*' hoặc bỏ qua các dấu
            // '(' dư thừa
            if (minOpen < 0)
                minOpen = 0;
        }

        return minOpen == 0;
    }
}
