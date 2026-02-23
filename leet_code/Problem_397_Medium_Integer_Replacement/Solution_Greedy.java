package leet_code.Problem_397_Medium_Integer_Replacement;

public class Solution_Greedy {

    /**
     * Minimum replacements to reach 1.
     * Use Greedy Bit Manipulation strategy.
     * Time: O(log N), Space: O(1).
     * 
     * Thay thế tối thiểu để đạt đến 1.
     * Sử dụng chiến lược Tham lam Thao tác Bit.
     */
    public int integerReplacement(int n) {
        long num = n; // Use long to handle n = Integer.MAX_VALUE easily
        int count = 0;

        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else if (num == 3 || num % 4 == 1) {
                // If num is 3 or ends in 01, subtract 1
                // Nếu num là 3 hoặc kết thúc bằng 01, trừ 1
                num--;
            } else {
                // If num ends in 11, add 1 (makes it divisible by 4)
                // Nếu num kết thúc bằng 11, cộng 1 (giúp chia hết cho 4)
                num++;
            }
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution_Greedy solution = new Solution_Greedy();

        // Test Case 1: 8 -> 3
        System.out.println("Result 8: " + solution.integerReplacement(8));

        // Test Case 2: 7 -> 4
        System.out.println("Result 7: " + solution.integerReplacement(7));

        // Test Case 3: 15 -> 5
        System.out.println("Result 15: " + solution.integerReplacement(15));
    }
}
