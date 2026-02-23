package leet_code.Problem_1014_Medium_Best_Sightseeing_Pair;

/**
 * Problem 1014: Best Sightseeing Pair
 * https://leetcode.com/problems/best-sightseeing-pair/
 */
public class Solution {

    /**
     * Calculates the maximum score of a sightseeing pair.
     * Strategy: Optimal One-Pass Max Tracking.
     * 
     * @param values The array of sightseeing spot values.
     * @return The maximum score.
     * 
     *         Tóm tắt chiến lược:
     *         1. Điểm số (Score) của 1 cặp (i, j) với i < j được tính bằng:
     *         values[i] + values[j] + i - j.
     *         2. Công thức trên có thể được khéo léo tách ra thành 2 cụm độc lập:
     *         (values[i] + i) VÀ (values[j] - j)
     *         3. Rõ ràng, khi chúng ta dời gót chân đến tham quan điểm `j`, cụm
     *         thứ hai `(values[j] - j)` là con số hiển nhiên, đã bị chốt chặt.
     *         4. Nhiệm vụ duy nhất lúc này để Điểm số nổ to nhất là:
     *         Nhìn ngược lại quá khứ xem cái Bức Tượng/Điểm i nào đằng sau
     *         có cụm sức mạnh `(values[i] + i)` LỚN NHẤT. Ta lôi nó ghép đôi!
     *         5. Cách cũ kỹ (Naive): Đứng ở j, lặp i từ đâu mảng duyệt lại, nát bét
     *         thời gian (O(N^2)). Đạt cực hạn 2.5 tỷ bước. (Lỗi TLE).
     *         6. Cách thông minh Tối Ưu (Optimal): Cử một trinh sát `maxI` đi thu
     *         thập kỷ lục `values[i] + i` lướt dọc từ đầu chí cuối.
     *         - Tới `j`, lấy kỷ lục trinh sát gộp với `(values[j] - j)` rồi đọ xem
     *         có lật đổ Tân Vương Tổng Điểm `maxScore` không.
     *         - Cùng lúc đó, `j` hiện tại cũng tự dóng sức nặng của bản thân
     *         `values[j] + j` để coi mình có phá kỷ lục của Trinh sát `maxI`
     *         làm bàn đạp cho đứa j tiếp theo xài không.
     *         7. Phương pháp Một-cú-lướt O(N), bay biến cái Vòng lặp. Cực sạch!
     */
    public int maxScoreSightseeingPair(int[] values) {
        // Trinh sát ghi chép "Quán quân" cụm i: (values[0] + 0)
        int maxI = values[0] + 0;

        // Quán quân Tổng điểm
        int maxScore = 0;

        // Tiến lùi dọc theo i
        for (int j = 1; j < values.length; j++) {
            // Điểm số cặp hiện hành: Đem "Trinh sát báo về" cộng với giá trị của mình j
            int currentPairScore = maxI + values[j] - j;

            // Có nổ đỉnh mới cho Tổng Quan không?
            maxScore = Math.max(maxScore, currentPairScore);

            // Xong vòng thi đấu, j tự đọ sức bản ngã để xem đủ trình đổi ngôi Trinh sát cho
            // tụi đằng sau dựa hơi hay không. (Biết đâu j ngon hơn i).
            maxI = Math.max(maxI, values[j] + j);
        }

        return maxScore;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] values1 = { 8, 1, 5, 2, 6 };
        System.out.println("Result 1: " + sol.maxScoreSightseeingPair(values1)); // expected 11

        int[] values2 = { 1, 2 };
        System.out.println("Result 2: " + sol.maxScoreSightseeingPair(values2)); // expected 2
    }
}
