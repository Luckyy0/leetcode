package Problem_1039_Medium_Minimum_Score_Triangulation_of_Polygon;

/**
 * 1039. Minimum Score Triangulation of Polygon
 * 
 * You have a convex n-sided polygon where each vertex has an integer value.
 * You triangulate the polygon into n - 2 triangles. For each triangle, the
 * value
 * is the product of its vertices. The total score is the sum over all
 * triangles.
 * Return the smallest possible total score.
 */
public class Solution {

    /**
     * Dùng Quy hoạch động (Dynamic Programming) trên khoảng (Interval DP).
     * 
     * @param values Mảng giá trị các đỉnh của đa giác
     * @return Điểm số (tổng tích 3 đỉnh của các tam giác tịnh tiến) nhỏ nhất có thể
     */
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        // Bảng sắt DP kích thước NxN. dp[i][j] là Điểm Min để đập vỡ, chia tam giác Đa
        // giác lồng kẹp [i tới j].
        int[][] dp = new int[n][n];

        // Mở cửa sổ DP: Độ rộng Cửa Sổ d trượt tịnh tiến dần từ size 2 (nhẹ nhất 3 đỉnh
        // tạo 1 tam giác)
        // cho tới khi Cửa Số Mở Rộng Ôm Toàn Cục (size N-1, ăn hết đa giác)
        for (int d = 2; d < n; d++) {
            // Rà từ Mút Trái i của Cối Xay Cửa Sổ
            for (int i = 0; i < n - d; i++) {
                int j = i + d; // Mút Phải j Chặn Vách Sổ

                dp[i][j] = Integer.MAX_VALUE; // Đặt mốc Vô Cực để rước Chốt Rút Gọn (Tìm Min)

                // Mổ xẻ kẽ nứt Điểm Đỉnh k nằm lọt khe giữa vòng cữ (i, j)
                // Cố định một cạnh Đáy i-j, tìm Đỉnh Thứ 3 (đỉnh k) để gộp lại thành Tam Giác
                for (int k = i + 1; k < j; k++) {
                    // Siết đinh cái Kỉ Lục Rẻ Nhặt Được Trong Các Nhát Chém Sinh Tam Giác Đỉnh K
                    int triangleScore = values[i] * values[k] * values[j];
                    int totalSubScore = dp[i][k] + dp[k][j] + triangleScore;

                    dp[i][j] = Math.min(dp[i][j], totalSubScore);
                }
            }
        }

        // Kỷ lục toàn bài sẽ nằm kẹt ở Khe bành trướng Chém Vỡ từ Mút 0 tới Mút N-1
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] values1 = { 1, 2, 3 };
        System.out.println("Test 1: " + sol.minScoreTriangulation(values1)); // Expected: 6

        int[] values2 = { 3, 7, 4, 5 };
        System.out.println("Test 2: " + sol.minScoreTriangulation(values2)); // Expected: 144

        int[] values3 = { 1, 3, 1, 4, 1, 5 };
        System.out.println("Test 3: " + sol.minScoreTriangulation(values3)); // Expected: 13
    }
}
