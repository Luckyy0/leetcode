package leet_code.Problem_316_Medium_Remove_Duplicate_Letters;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_Stack {

    /**
     * Removes duplicate letters maintaining lexicographical order.
     * Uses Monotonic Stack approach.
     * Time: O(N), Space: O(1) (max 26 chars).
     * 
     * Loại bỏ các chữ cái trùng lặp duy trì thứ tự từ điển.
     * Sử dụng phương pháp Ngăn xếp Đơn điệu.
     */
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        boolean[] visited = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            int index = c - 'a';
            freq[index]--;

            if (visited[index]) {
                continue;
            }

            // Pop elements that are greater than current and can be added later
            // Pop các phần tử lớn hơn hiện tại và có thể được thêm sau
            while (!stack.isEmpty() && stack.peek() > c && freq[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            visited[index] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast()); // Stack builds from bottom up
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution_Stack solution = new Solution_Stack();

        // Test Case 1: "bcabc" -> "abc"
        System.out.println("Result 1: " + solution.removeDuplicateLetters("bcabc"));

        // Test Case 2: "cbacdcbc" -> "acdb"
        System.out.println("Result 2: " + solution.removeDuplicateLetters("cbacdcbc"));
    }
}
