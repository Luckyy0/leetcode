package leet_code.Problem_6_Medium_Zigzag_Conversion;

public class Solution_Simulation {

    /**
     * Converts a string to zigzag pattern.
     * Simulation approach using O(N) Time and O(N) Space.
     * Chuyển đổi một chuỗi thành mô hình zigzag.
     * Phương pháp mô phỏng sử dụng O(N) Thời gian và O(N) Không gian.
     */
    public String convert(String s, int numRows) {
        // Edge cases where no zigzagging happens
        // Các trường hợp biên mà không có zigzag xảy ra
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        // Initialize rows
        // Khởi tạo các hàng
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Iterate through each character
        // Duyệt qua từng ký tự
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // If at the top or bottom row, reverse direction
            // Nếu ở hàng trên cùng hoặc dưới cùng, đảo ngược hướng
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move to next row
            // Di chuyển đến hàng tiếp theo
            currentRow += goingDown ? 1 : -1;
        }

        // Combine all rows
        // Kết hợp tất cả các hàng
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_Simulation solution = new Solution_Simulation();

        // Test Case 1
        String s1 = "PAYPALISHIRING";
        int numRows1 = 3;
        String r1 = solution.convert(s1, numRows1);
        System.out.println("Test Case 1: " + r1);
        // Expected: "PAHNAPLSIIGYIR"

        // Test Case 2
        String s2 = "PAYPALISHIRING";
        int numRows2 = 4;
        String r2 = solution.convert(s2, numRows2);
        System.out.println("Test Case 2: " + r2);
        // Expected: "PINALSIGYAHRPI"

        // Test Case 3: Single row
        String s3 = "A";
        int numRows3 = 1;
        String r3 = solution.convert(s3, numRows3);
        System.out.println("Test Case 3: " + r3);
        // Expected: "A"
    }
}
