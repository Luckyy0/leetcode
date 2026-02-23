package leet_code.Problem_256_Medium_Paint_House;

public class Solution_DP {

    /**
     * Calculates minimum cost to paint all houses.
     * Uses In-Place Dynamic Programming.
     * Time: O(N), Space: O(1) (modifying input).
     * 
     * Tính chi phí tối thiểu để sơn tất cả các ngôi nhà.
     * Sử dụng Quy hoạch động tại chỗ.
     */
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int n = costs.length;

        // Iterate from the second house
        // Duyệt từ ngôi nhà thứ hai
        for (int i = 1; i < n; i++) {
            // Cost to paint current Red = current Red + min(prev Blue, prev Green)
            // Chi phí sơn Đỏ hiện tại = Đỏ hiện tại + min(Xanh lam trước, Xanh lục trước)
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);

            // Cost to paint current Blue = current Blue + min(prev Red, prev Green)
            // Chi phí sơn Xanh lam hiện tại = Xanh lam hiện tại + min(Đỏ trước, Xanh lục
            // trước)
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);

            // Cost to paint current Green = current Green + min(prev Red, prev Blue)
            // Chi phí sơn Xanh lục hiện tại = Xanh lục hiện tại + min(Đỏ trước, Xanh lam
            // trước)
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }

        // The answer is the minimum of the last row
        // Câu trả lời là giá trị nhỏ nhất của hàng cuối cùng
        return Math.min(costs[n - 1][0], Math.min(costs[n - 1][1], costs[n - 1][2]));
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1: [[17,2,17],[16,16,5],[14,3,19]] -> 10
        int[][] costs1 = { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } };
        System.out.println("Min Cost 1: " + solution.minCost(costs1));

        // Test Case 2: [[7,6,2]] -> 2
        int[][] costs2 = { { 7, 6, 2 } };
        System.out.println("Min Cost 2: " + solution.minCost(costs2));
    }
}
