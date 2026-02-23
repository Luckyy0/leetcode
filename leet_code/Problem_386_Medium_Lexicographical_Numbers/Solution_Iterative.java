package leet_code.Problem_386_Medium_Lexicographical_Numbers;

import java.util.ArrayList;
import java.util.List;

public class Solution_Iterative {

    /**
     * Returns numbers 1 to n in lexicographical order.
     * Uses O(N) time and O(1) extra space.
     * Time: O(N), Space: O(1).
     * 
     * Trả về các số từ 1 đến n theo thứ tự từ điển.
     * Sử dụng thời gian O(N) và không gian phụ O(1).
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int curr = 1;

        for (int i = 0; i < n; i++) {
            res.add(curr);

            if (curr * 10 <= n) {
                // Go deeper (e.g., from 1 to 10)
                // Đi sâu hơn (ví dụ: từ 1 đến 10)
                curr *= 10;
            } else {
                // If we can't go deeper, go to the next sibling
                // Nếu không thể đi sâu hơn, hãy chuyển sang nhánh anh chị em tiếp theo
                while (curr % 10 == 9 || curr + 1 > n) {
                    curr /= 10;
                }
                curr++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_Iterative solution = new Solution_Iterative();

        // Test Case 1: n = 13
        System.out.println("Result 13: " + solution.lexicalOrder(13));

        // Test Case 2: n = 2
        System.out.println("Result 2: " + solution.lexicalOrder(2));
    }
}
