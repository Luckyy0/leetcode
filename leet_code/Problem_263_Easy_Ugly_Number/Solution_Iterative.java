package leet_code.Problem_263_Easy_Ugly_Number;

public class Solution_Iterative {

    /**
     * Checks if a number is an ugly number.
     * Uses Iterative Division.
     * Time: O(log N), Space: O(1).
     * 
     * Kiểm tra xem một số có phải là số xấu không.
     * Sử dụng Chia lặp.
     */
    public boolean isUgly(int n) {
        // An ugly number must be positive
        // Số xấu phải là số dương
        if (n <= 0) {
            return false;
        }

        // Divide by 2, 3, 5 as much as possible
        // Chia cho 2, 3, 5 nhiều nhất có thể
        while (n % 2 == 0)
            n /= 2;
        while (n % 3 == 0)
            n /= 3;
        while (n % 5 == 0)
            n /= 5;

        // If the remaining number is 1, it only had prime factors 2, 3, 5
        // Nếu số còn lại là 1, nó chỉ có các thừa số nguyên tố 2, 3, 5
        return n == 1;
    }

    public static void main(String[] args) {
        Solution_Iterative solution = new Solution_Iterative();

        // Test Case 1: 6 -> true
        System.out.println("Is 6 Ugly? " + solution.isUgly(6));

        // Test Case 2: 1 -> true
        System.out.println("Is 1 Ugly? " + solution.isUgly(1));

        // Test Case 3: 14 -> false
        System.out.println("Is 14 Ugly? " + solution.isUgly(14));
    }
}
