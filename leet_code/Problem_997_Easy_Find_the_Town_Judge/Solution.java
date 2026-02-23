package leet_code.Problem_997_Easy_Find_the_Town_Judge;

/**
 * Problem 997: Find the Town Judge
 * https://leetcode.com/problems/find-the-town-judge/
 */
public class Solution {

    /**
     * Determines if there is a town judge.
     * Strategy: Directed Graph In/Out Degree tracking.
     * 
     * @param n     Number of people.
     * @param trust Array of trust relationships [a, b].
     * @return Label of the town judge, or -1.
     * 
     *         Tóm tắt chiến lược:
     *         1. Có thể coi đây là bài toán Đồ thị có hướng (Directed Graph).
     *         - 'a' tin 'b' nghĩa là có một cạnh từ 'a' trỏ đến 'b'.
     *         - Thẩm phán không tin ai: Không có cạnh Bắt Đầu từ thẩm phán (bậc ra
     *         = 0).
     *         - Mọi người đều tin thẩm phán: Có N - 1 cạnh trỏ tới thẩm phán (bậc
     *         vào = n - 1).
     *         2. Thay vì dùng hai mảng để lưu bậc vào và bậc ra, ta dùng 1 mảng
     *         Mạng Tin Cậy Ròng (`trustScores` chứa "Net Trust").
     *         - Khi 'a' tin 'b', điểm tin cậy của 'a' giảm đi 1 (do đã đặt niềm tin
     *         vào người khác).
     *         - Khi 'b' được tin tưởng, điểm tin cậy của 'b' tăng thêm 1 (do nhận
     *         được một "phiếu bầu").
     *         3. Kết quả là, Thẩm phán THỰC SỰ sẽ có chính xác (N - 1) điểm. Không
     *         ai khác ngoài thẩm phán có thể có N - 1 điểm (vì ít nhất họ cũng phải
     *         bỏ ra 1 "phiếu bầu" cho ai đó, hoặc không được đầy đủ những người còn
     *         lại tin tưởng).
     *         4. Duyệt `trust` một lần để cập nhật điểm. Sau đó duyệt từ `1` tới
     *         `n` để tìm ra người duy nhất có điểm `n-1`.
     */
    public int findJudge(int n, int[][] trust) {
        // If no one trusts anyone, person 1 is the judge only if n == 1
        if (trust.length == 0) {
            return n == 1 ? 1 : -1;
        }

        // 1-indexed array to track the "net trust" score for each person
        int[] trustScores = new int[n + 1];

        // Process every trust interaction
        for (int[] t : trust) {
            int personWhoTrusts = t[0];
            int personBeingTrusted = t[1];

            // Person loses trust score by trusting someone else
            trustScores[personWhoTrusts]--;
            // Person gains trust score by being trusted
            trustScores[personBeingTrusted]++;
        }

        // The town judge is the only one who did not lose any trust score
        // AND gained N - 1 trust score from everybody else.
        for (int i = 1; i <= n; i++) {
            if (trustScores[i] == n - 1) {
                return i;
            }
        }

        // Condition not met, thus no judge
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int n1 = 2;
        int[][] t1 = { { 1, 2 } };
        System.out.println("Result 1: " + sol.findJudge(n1, t1)); // 2

        int n2 = 3;
        int[][] t2 = { { 1, 3 }, { 2, 3 } };
        System.out.println("Result 2: " + sol.findJudge(n2, t2)); // 3

        int n3 = 3;
        int[][] t3 = { { 1, 3 }, { 2, 3 }, { 3, 1 } };
        System.out.println("Result 3: " + sol.findJudge(n3, t3)); // -1
    }
}
