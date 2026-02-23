package leet_code.Problem_319_Medium_Bulb_Switcher;

public class Solution_Math {

    /**
     * Calculates number of bulbs on.
     * Use Math property: Only perfect squares have odd number of divisors.
     * Time: O(1), Space: O(1).
     * 
     * Tính số lượng bóng đèn đang bật.
     * Sử dụng tính chất Toán học: Chỉ số chính phương mới có số ước số lẻ.
     */
    public int bulbSwitch(int n) {
        // Find distinct perfect squares from 1 to n
        // Tìm các số chính phương khác nhau từ 1 đến n
        return (int) Math.sqrt(n);
    }

    public static void main(String[] args) {
        Solution_Math solution = new Solution_Math();

        // Test Case 1: n = 3 -> 1
        System.out.println("Bulbs On 1: " + solution.bulbSwitch(3));

        // Test Case 2: n = 0 -> 0
        System.out.println("Bulbs On 2: " + solution.bulbSwitch(0));

        // Test Case 3: n = 5 -> 2
        System.out.println("Bulbs On 3: " + solution.bulbSwitch(5));
    }
}
