package leet_code.Problem_400_Medium_Nth_Digit;

public class Solution_Math {

    /**
     * Finds the nth digit of the integer sequence 1, 2, 3...
     * Uses a three-step mathematical localization.
     * Time: O(log N), Space: O(1).
     * 
     * Tìm chữ số thứ n của chuỗi số nguyên 1, 2, 3...
     * Sử dụng phương pháp định vị toán học ba bước.
     */
    public int findNthDigit(int n) {
        int len = 1; // Current number length (1-digit, 2-digits...)
        long count = 9; // Total digits in current length group
        int start = 1; // Smallest number in current group (1, 10, 100...)

        // Step 1: Find the length of the number that contains the nth digit
        // Bước 1: Tìm độ dài của số chứa chữ số thứ n
        while (n > (long) len * count) {
            n -= len * count;
            len++;
            count *= 10;
            start *= 10;
        }

        // Step 2: Find the actual number
        // Bước 2: Tìm con số thực tế
        int targetNumber = start + (n - 1) / len;

        // Step 3: Find the specific digit in targetNumber
        // Bước 3: Tìm chữ số cụ thể trong targetNumber
        String s = Integer.toString(targetNumber);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }

    public static void main(String[] args) {
        Solution_Math solution = new Solution_Math();

        // Test Case 1: n=3 -> 3
        System.out.println("Result 3: " + solution.findNthDigit(3));

        // Test Case 2: n=11 -> 0
        System.out.println("Result 11: " + solution.findNthDigit(11));
    }
}
