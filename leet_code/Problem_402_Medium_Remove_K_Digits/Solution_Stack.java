package leet_code.Problem_402_Medium_Remove_K_Digits;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_Stack {

    /**
     * Removes K digits to form the smallest number.
     * Uses a monotonic stack (greedy).
     * Time: O(N), Space: O(N).
     * 
     * Xóa K chữ số để tạo thành số nhỏ nhất.
     * Sử dụng ngăn xếp đơn điệu (tham lam).
     */
    public String removeKdigits(String num, int k) {
        if (k >= num.length())
            return "0";

        Deque<Character> stack = new LinkedList<>();

        for (char c : num.toCharArray()) {
            // While digits are descending, remove the larger ones from peak
            // Khi các chữ số đang giảm dần, loại bỏ các số lớn hơn từ đỉnh
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > c) {
                stack.removeLast();
                k--;
            }
            stack.addLast(c);
        }

        // Remove remaining k from the tail
        // Loại bỏ k còn lại từ cuối
        while (k > 0) {
            stack.removeLast();
            k--;
        }

        // Build the string and remove leading zeros
        // Xây dựng chuỗi và loại bỏ các số 0 ở đầu
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for (char c : stack) {
            if (leadingZero && c == '0')
                continue;
            leadingZero = false;
            sb.append(c);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        Solution_Stack solution = new Solution_Stack();

        // Test Case 1: "1432219", k=3 -> "1219"
        System.out.println("Result 1: " + solution.removeKdigits("1432219", 3));

        // Test Case 2: "10200", k=1 -> "200"
        System.out.println("Result 2: " + solution.removeKdigits("10200", 1));

        // Test Case 3: "10", k=2 -> "0"
        System.out.println("Result 3: " + solution.removeKdigits("10", 2));
    }
}
