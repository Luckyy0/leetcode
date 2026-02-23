package leet_code.Problem_357_Medium_Count_Numbers_With_Unique_Digits;

public class Solution_Math {

    /**
     * Counts numbers with unique digits up to 10^n.
     * Uses Combinatorics.
     * Time: O(N), Space: O(1).
     * 
     * Đếm các số có chữ số duy nhất lên đến 10^n.
     * Sử dụng Tổ hợp.
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;

        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;

        while (n > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            res += uniqueDigits;
            availableNumber--;
            n--;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_Math solution = new Solution_Math();

        // Test Case 1: n = 2 -> 91
        System.out.println("Result n=2: " + solution.countNumbersWithUniqueDigits(2));

        // Test Case 2: n = 0 -> 1
        System.out.println("Result n=0: " + solution.countNumbersWithUniqueDigits(0));
    }
}
