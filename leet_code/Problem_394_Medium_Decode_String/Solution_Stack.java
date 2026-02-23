package leet_code.Problem_394_Medium_Decode_String;

import java.util.Stack;

public class Solution_Stack {

    /**
     * Decodes an encoded string.
     * Uses two stacks for multipliers and prefix strings.
     * Time: O(DecodedLength), Space: O(NestingDepth + DecodedLength).
     * 
     * Giải mã một chuỗi đã mã hóa.
     * Sử dụng hai ngăn xếp cho hệ số nhân và các chuỗi tiền tố.
     */
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> resStack = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Multi-digit multiplier support
                // Hỗ trợ hệ số nhân nhiều chữ số
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(k);
                resStack.push(cur);
                cur = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder tmp = cur;
                cur = resStack.pop();
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    cur.append(tmp);
                }
            } else {
                cur.append(ch);
            }
        }

        return cur.toString();
    }

    public static void main(String[] args) {
        Solution_Stack solution = new Solution_Stack();

        // Test Case 1: "3[a]2[bc]" -> "aaabcbc"
        System.out.println("Result 1: " + solution.decodeString("3[a]2[bc]"));

        // Test Case 2: "3[a2[c]]" -> "accaccacc"
        System.out.println("Result 2: " + solution.decodeString("3[a2[c]]"));

        // Test Case 3: "2[abc]3[cd]ef" -> "abcabccdcdcdef"
        System.out.println("Result 3: " + solution.decodeString("2[abc]3[cd]ef"));
    }
}
