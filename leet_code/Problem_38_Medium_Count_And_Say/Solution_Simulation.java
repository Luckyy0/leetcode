package leet_code.Problem_38_Medium_Count_And_Say;

public class Solution_Simulation {

    /**
     * Generates the n-th Count-and-Say sequence.
     * Uses Iterative Simulation.
     * Tạo chuỗi Đếm và Nói thứ n.
     * Sử dụng Mô phỏng Lặp.
     */
    public String countAndSay(int n) {
        if (n <= 0)
            return "";
        String result = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            int len = result.length();

            for (int j = 0; j < len; j++) {
                // If it's the last char or next char is different
                // Nếu là ký tự cuối cùng hoặc ký tự tiếp theo khác biệt
                if (j == len - 1 || result.charAt(j) != result.charAt(j + 1)) {
                    sb.append(count);
                    sb.append(result.charAt(j));
                    count = 1; // Reset count
                } else {
                    count++;
                }
            }
            result = sb.toString();
        }

        return result;
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_Simulation solution = new Solution_Simulation();

        // Test Case 1
        int n1 = 1;
        System.out.println("Test Case 1: " + solution.countAndSay(n1));
        // Expected: "1"

        // Test Case 2
        int n2 = 4;
        System.out.println("Test Case 2: " + solution.countAndSay(n2));
        // Expected: "1211"

        // Test Case 3
        int n3 = 5;
        System.out.println("Test Case 3: " + solution.countAndSay(n3));
        // Expected: "111221"
    }
}
