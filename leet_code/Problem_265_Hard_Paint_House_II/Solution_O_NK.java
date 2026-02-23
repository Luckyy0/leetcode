package leet_code.Problem_265_Hard_Paint_House_II;

public class Solution_O_NK {

    /**
     * Calculates minimum cost to paint all houses with k colors.
     * Uses O(NK) DP optimization by tracking min1 and min2.
     * Time: O(NK), Space: O(1).
     * 
     * Tính chi phí tối thiểu để sơn tất cả các ngôi nhà với k màu.
     * Sử dụng tối ưu hóa DP O(NK) bằng cách theo dõi min1 và min2.
     */
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int n = costs.length;
        int k = costs[0].length;

        // Track the minimum cost and the second minimum cost of the PREVIOUS row
        // Also track the index of the color that produced the minimum cost
        // Theo dõi chi phí tối thiểu và chi phí tối thiểu thứ hai của hàng TRƯỚC
        // Cũng theo dõi chỉ số của màu tạo ra chi phí tối thiểu
        int prevMin1 = 0, prevMin2 = 0, prevMinColor = -1;

        for (int i = 0; i < n; i++) {
            int currMin1 = Integer.MAX_VALUE;
            int currMin2 = Integer.MAX_VALUE;
            int currMinColor = -1;

            for (int color = 0; color < k; color++) {
                // Cost for current house with current color
                // If current color is same as prevMinColor, we must use prevMin2
                // Otherwise we use prevMin1
                // Chi phí cho ngôi nhà hiện tại với màu hiện tại
                // Nếu màu hiện tại giống prevMinColor, phải dùng prevMin2
                // Nếu không thì dùng prevMin1
                int cost = costs[i][color] + (color == prevMinColor ? prevMin2 : prevMin1);

                // Update current row's min1 and min2
                // Cập nhật min1 và min2 của hàng hiện tại
                if (cost < currMin1) {
                    currMin2 = currMin1;
                    currMin1 = cost;
                    currMinColor = color;
                } else if (cost < currMin2) {
                    currMin2 = cost;
                }
            }

            // Move current to previous for next iteration
            // Chuyển hiện tại thành trước đó cho vòng lặp tiếp theo
            prevMin1 = currMin1;
            prevMin2 = currMin2;
            prevMinColor = currMinColor;
        }

        return prevMin1;
    }

    public static void main(String[] args) {
        Solution_O_NK solution = new Solution_O_NK();

        // Test Case 1: [[1,5,3],[2,9,4]] -> 5
        int[][] costs1 = { { 1, 5, 3 }, { 2, 9, 4 } };
        System.out.println("Min Cost 1: " + solution.minCostII(costs1));

        // Test Case 2: [[1,3],[2,4]] -> 5
        int[][] costs2 = { { 1, 3 }, { 2, 4 } };
        System.out.println("Min Cost 2: " + solution.minCostII(costs2));
    }
}
