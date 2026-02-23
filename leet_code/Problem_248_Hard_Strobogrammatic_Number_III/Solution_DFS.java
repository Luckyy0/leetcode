package leet_code.Problem_248_Hard_Strobogrammatic_Number_III;

public class Solution_DFS {

    private final char[][] pairs = { { '0', '0' }, { '1', '1' }, { '6', '9' }, { '8', '8' }, { '9', '6' } };
    private int count = 0;

    /**
     * Counts strobogrammatic numbers in range [low, high].
     * Uses DFS generation with boundary checks.
     * Time: O(5^(N/2)), Space: O(N).
     * 
     * Đếm các số strobogrammatic trong phạm vi [low, high].
     * Sử dụng sinh DFS với kiểm tra biên.
     */
    public int strobogrammaticInRange(String low, String high) {
        count = 0;
        for (int len = low.length(); len <= high.length(); len++) {
            dfs(low, high, new char[len], 0, len - 1);
        }
        return count;
    }

    private void dfs(String low, String high, char[] c, int left, int right) {
        if (left > right) {
            String s = new String(c);
            // Check lower bound
            if (s.length() == low.length() && s.compareTo(low) < 0) {
                return;
            }
            // Check upper bound
            if (s.length() == high.length() && s.compareTo(high) > 0) {
                return;
            }
            count++;
            return;
        }

        for (char[] p : pairs) {
            c[left] = p[0];
            c[right] = p[1];

            // Skip numbers starting with '0' unless it's just "0"
            // Bỏ qua số bắt đầu bằng '0' trừ khi nó là "0"
            if (c.length != 1 && c[0] == '0') {
                continue;
            }

            // Skip invalid middle digit (6 and 9 cannot be in the middle of odd length)
            // Bỏ qua chữ số giữa không hợp lệ (6 và 9 không thể ở giữa độ dài lẻ)
            if (left == right && (p[0] == '6' || p[0] == '9')) {
                continue;
            }

            dfs(low, high, c, left + 1, right - 1);
        }
    }

    public static void main(String[] args) {
        Solution_DFS solution = new Solution_DFS();

        // Test Case 1: "50" to "100" -> 3 (69, 88, 96)
        System.out.println("Count 1: " + solution.strobogrammaticInRange("50", "100"));

        // Test Case 2: "0" to "0" -> 1 (0)
        System.out.println("Count 2: " + solution.strobogrammaticInRange("0", "0"));
    }
}
