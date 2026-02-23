package leet_code.Problem_202_Easy_Happy_Number;

import java.util.HashSet;
import java.util.Set;

public class Solution_FloydCycle {

    /**
     * Determines if a number is a "Happy Number".
     * Uses Floyd's Cycle-Finding Algorithm (Tortoise and Hare).
     * Time: O(log N), Space: O(1).
     * 
     * Xác định xem một số có phải là "Số hạnh phúc" hay không.
     * Sử dụng Thuật toán phát hiện chu kỳ Floyd (Rùa và Thỏ).
     */
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        // Continue until fast meets slow or reaches 1
        // Tiếp tục cho đến khi Fast gặp Slow hoặc đạt tới 1
        while (fast != 1 && slow != fast) {
            slow = getNext(slow); // Move 1 step
            fast = getNext(getNext(fast)); // Move 2 steps
        }

        return fast == 1;
    }

    // Helper to calculate sum of squares of digits
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int digit = n % 10;
            n = n / 10;
            totalSum += digit * digit;
        }
        return totalSum;
    }

    public static void main(String[] args) {
        Solution_FloydCycle solution = new Solution_FloydCycle();

        // Test Case 1: 19 -> True
        System.out.println("Is 19 Happy? " + solution.isHappy(19));

        // Test Case 2: 2 -> False
        System.out.println("Is 2 Happy? " + solution.isHappy(2));
    }
}
