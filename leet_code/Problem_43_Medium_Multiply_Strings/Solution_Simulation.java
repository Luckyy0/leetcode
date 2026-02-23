package leet_code.Problem_43_Medium_Multiply_Strings;

public class Solution_Simulation {

    /**
     * Multiplies two numbers represented as strings.
     * Uses elementary multiplication simulation.
     * Nhân hai số dưới dạng chuỗi.
     * Sử dụng mô phỏng phép nhân tiểu học.
     */
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int[] pos = new int[n1 + n2];

        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p2] = sum % 10;
                pos[p1] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_Simulation solution = new Solution_Simulation();

        // Test Case 1
        System.out.println("Test Case 1: " + solution.multiply("2", "3"));
        // Expected: "6"

        // Test Case 2
        System.out.println("Test Case 2: " + solution.multiply("123", "456"));
        // Expected: "56088"

        // Test Case 3: Zero
        System.out.println("Test Case 3: " + solution.multiply("0", "456"));
        // Expected: "0"
    }
}
