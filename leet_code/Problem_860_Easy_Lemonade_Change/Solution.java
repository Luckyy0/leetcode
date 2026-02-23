package leet_code.Problem_860_Easy_Lemonade_Change;

/**
 * Problem 860: Lemonade Change
 * https://leetcode.com/problems/lemonade-change/
 */
public class Solution {

    /**
     * Determines if correct change can be provided for every customer.
     * Strategy: Greedy Simulation. Always prioritize giving out $10 bills
     * before $5 bills when making change for $20.
     * 
     * @param bills Order of bills paid by customers.
     * @return True if successful change for all.
     * 
     *         Tóm tắt chiến lược:
     *         Chúng ta lưu số lượng tờ $5 và $10. Tờ $5 rất quan trọng vì có thể
     *         thối
     *         cho cả tờ $10 và $20. Khi thối cho tờ $20, hãy ưu tiên dùng 1 tờ $10
     *         + 1 tờ $5
     *         để giữ lại các tờ $5 quý giá.
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                // If customer pays $5, no change needed
                five++;
            } else if (bill == 10) {
                // If customer pays $10, we need one $5 for change
                if (five == 0)
                    return false;
                five--;
                ten++;
            } else { // bill == 20
                // If customer pays $20, we need $15 in change
                // First choice (Greedy): one $10 and one $5
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                }
                // Second choice: three $5
                else if (five >= 3) {
                    five -= 3;
                }
                // Cannot provide change
                else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] b1 = { 5, 5, 5, 10, 20 };
        System.out.println("Result: " + sol.lemonadeChange(b1)); // true

        int[] b2 = { 5, 5, 10, 10, 20 };
        System.out.println("Result: " + sol.lemonadeChange(b2)); // false
    }
}
