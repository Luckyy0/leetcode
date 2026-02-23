package leet_code.Problem_67_Easy_Add_Binary;

public class Solution_Simulation {

    /**
     * Adds two binary strings.
     * Uses bit-by-bit simulation.
     * Cộng hai chuỗi nhị phân.
     * Sử dụng mô phỏng từng bit.
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }

            // Result bit at current position
            // Bit kết quả tại vị trí hiện tại
            sb.append(sum % 2);

            // Calculate carry for next position
            // Tính số nhớ cho vị trí tiếp theo
            carry = sum / 2;
        }

        // Result is generated in reverse order
        // Kết quả được tạo theo thứ tự ngược
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution_Simulation solution = new Solution_Simulation();

        // Test Case 1
        System.out.println("Test Case 1: " + solution.addBinary("11", "1"));
        // Expected: "100"

        // Test Case 2
        System.out.println("Test Case 2: " + solution.addBinary("1010", "1011"));
        // Expected: "10101"
    }
}
