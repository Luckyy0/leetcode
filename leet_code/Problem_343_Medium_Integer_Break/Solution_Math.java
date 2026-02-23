package leet_code.Problem_343_Medium_Integer_Break;

public class Solution_Math {

    /**
     * Maximizes integer break product.
     * Uses Math property: Factors of 3 are best.
     * Time: O(1) (impl uses pow so O(log N)), Space: O(1).
     * 
     * Tối đa hóa tích chia nhỏ số nguyên.
     * Sử dụng tính chất toán học: Thừa số 3 là tốt nhất.
     */
    public int integerBreak(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;

        int remainder = n % 3;

        if (remainder == 0) {
            // n is 3k. Result 3^k.
            return (int) Math.pow(3, n / 3);
        } else if (remainder == 1) {
            // n is 3k + 1. Better to have 3^(k-1) * 2 * 2 = 3^(k-1) * 4.
            // Example 10: 3+3+3+1 -> 3*3*3*1=27.
            // Replace 3+1 with 2+2 -> 3*3*2*2=36.
            return (int) Math.pow(3, (n / 3) - 1) * 4;
        } else {
            // n is 3k + 2. Result 3^k * 2.
            return (int) Math.pow(3, n / 3) * 2;
        }
    }

    public static void main(String[] args) {
        Solution_Math solution = new Solution_Math();

        // Test Case 1: 2 -> 1
        System.out.println("Result 1: " + solution.integerBreak(2));

        // Test Case 2: 10 -> 36
        System.out.println("Result 2: " + solution.integerBreak(10));

        // Test Case 3: 5 -> 6 (2*3)
        System.out.println("Result 3: " + solution.integerBreak(5));
    }
}
