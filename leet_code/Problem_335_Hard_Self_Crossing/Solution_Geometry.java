package leet_code.Problem_335_Hard_Self_Crossing;

public class Solution_Geometry {

    /**
     * Checks if path crosses itself.
     * Uses Geometry conditions for 4, 5, 6 lines.
     * Time: O(N), Space: O(1).
     * 
     * Kiểm tra xem đường đi có tự cắt không.
     * Sử dụng các điều kiện Hình học cho 4, 5, 6 đường.
     */
    public boolean isSelfCrossing(int[] x) {
        int n = x.length;
        if (n <= 3)
            return false;

        for (int i = 3; i < n; i++) {
            // Case 1: Fourth line crosses first line or later
            // Trường hợp 1: Đường thứ tư cắt đường thứ nhất hoặc sau đó
            if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) {
                return true;
            }

            // Case 2: Fifth line meets first line
            // Trường hợp 2: Đường thứ năm gặp đường thứ nhất
            if (i >= 4) {
                if (x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2]) {
                    return true;
                }
            }

            // Case 3: Sixth line crosses first line
            // Trường hợp 3: Đường thứ sáu cắt đường thứ nhất
            if (i >= 5) {
                if (x[i - 1] <= x[i - 3] && x[i - 1] + x[i - 5] >= x[i - 3] &&
                        x[i - 2] > x[i - 4] && x[i] + x[i - 4] >= x[i - 2]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_Geometry solution = new Solution_Geometry();

        // Test Case 1: [2,1,1,2] -> true
        int[] d1 = { 2, 1, 1, 2 };
        System.out.println("Result 1: " + solution.isSelfCrossing(d1));

        // Test Case 2: [1,2,3,4] -> false
        int[] d2 = { 1, 2, 3, 4 };
        System.out.println("Result 2: " + solution.isSelfCrossing(d2));

        // Test Case 3: [1,1,1,1] -> true
        int[] d3 = { 1, 1, 1, 1 };
        System.out.println("Result 3: " + solution.isSelfCrossing(d3));
    }
}
