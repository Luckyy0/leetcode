package leet_code.Problem_948_Medium_Bag_of_Tokens;

import java.util.Arrays;

/**
 * Problem 948: Bag of Tokens
 * https://leetcode.com/problems/bag-of-tokens/
 */
public class Solution {

    /**
     * Maximizes the score by strategically playing tokens.
     * Strategy: Greedy Approach with Sorting and Two Pointers.
     * 
     * @param tokens Array of token values.
     * @param power  Initial power.
     * @return Maximum score achievable.
     * 
     *         Tóm tắt chiến lược:
     *         1. Sắp xếp mảng `tokens` tăng dần. Điều này rất quan trọng để thực
     *         hiện chiến lược tham lam.
     *         2. Sử dụng hai con trỏ:
     *         - `low`: trỏ đến token có giá trị nhỏ nhất (để mua điểm).
     *         - `high`: trỏ đến token có giá trị lớn nhất (để bán lấy sức mạnh).
     *         3. Tại mỗi bước, ta ưu tiên:
     *         - Nếu đủ `power` để mua token rẻ nhất (`tokens[low]`):
     *         - Mua ngay (Face Up): giảm `power`, tăng `score`, tăng `low`.
     *         - Cập nhật `maxScore` vì điểm số có thể đạt đỉnh ở đây trước khi bị
     *         giảm do bán token.
     *         - Nếu không đủ `power` nhưng có `score >= 1`:
     *         - Bán token đắt nhất (Face Down) để lấy `power` tối đa: giảm `score`,
     *         tăng `power`, giảm `high`.
     *         - Tuy nhiên, chỉ bán nếu còn token khác để mua trong tương lai (`low
     *         < high`). Nếu chỉ còn 1 token (`low == high`), việc bán nó sẽ không
     *         giúp ta mua thêm gì cả, nên không bán.
     *         - Nếu không đủ `power` và không có `score` (hoặc không muốn bán):
     *         Dừng lại.
     */
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);

        int low = 0;
        int high = tokens.length - 1;
        int score = 0;
        int maxScore = 0;

        while (low <= high) {
            // Priority 1: Buy token if we have enough power (Face Up)
            if (power >= tokens[low]) {
                power -= tokens[low];
                score++;
                low++;
                maxScore = Math.max(maxScore, score);
            }
            // Priority 2: Sell token for power if we have score (Face Down)
            // But only if we have more tokens to potentially buy (low < high)
            else if (score > 0 && low < high) {
                power += tokens[high];
                score--;
                high--;
            }
            // Priority 3: Cannot make any move
            else {
                break;
            }
        }

        return maxScore;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] t1 = { 100 };
        System.out.println("Result: " + sol.bagOfTokensScore(t1, 50)); // 0

        int[] t2 = { 100, 200 };
        System.out.println("Result: " + sol.bagOfTokensScore(t2, 150)); // 1

        int[] t3 = { 100, 200, 300, 400 };
        System.out.println("Result: " + sol.bagOfTokensScore(t3, 200)); // 2
    }
}
