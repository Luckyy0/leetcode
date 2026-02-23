package leet_code.Problem_1007_Medium_Minimum_Domino_Rotations_For_Equal_Row;

/**
 * Problem 1007: Minimum Domino Rotations For Equal Row
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 */
public class Solution {

    /**
     * Finds the minimum number of rotations.
     * Strategy: Optimal constant checking.
     * 
     * @param tops    The top domino array.
     * @param bottoms The bottom domino array.
     * @return Minimum swaps or -1 if impossible.
     * 
     *         Tóm tắt chiến lược:
     *         1. Hàng domino muốn đồng nhất một giá trị mục tiêu 'target', thì
     *         'target' đó BẮT BUỘC phải nằm ở domino đầu tiên (nghĩa là nó phải
     *         thuộc về tops[0] hoặc bottoms[0]). Bất kì số nào khác hoàn toàn bị
     *         bãi bỏ.
     *         2. Vì vậy, thay vì phải quét trọn bộ từ số 1 -> 6 (gây tốn 12 vòng
     *         lập không đáng có), ta CHỈ CẦN kiểm tra đúng 2 ứng cử viên:
     *         - Ứng cử viên thứ nhất là tops[0].
     *         - Ứng cử viên thứ hai là bottoms[0].
     *         3. Tạo một hàm dùng chung trợ giúp tên là `check(target)`.
     *         - Hàm này sẽ đi dọc qua n phần tử.
     *         - Nếu tại bước i, không có domino trên (A[i]) cũng không có
     *         domino dưới (B[i]) khớp cái taget đó, thất bại lập tức (-1).
     *         - Cùng lúc đếm xem mất bao nhiêu swap để đổ bộ cờ target lên hàng
     *         Top.
     *         - Cũng cùng lúc đếm xem mất bao swap để đổ cờ target xuống hàng Bot.
     *         - Trả về lấy min.
     *         4. Lần 1 gọi check với target = tops[0]. Nếu được, nhả kết quả ngay.
     *         5. Nếu lật tops[0] thất bại, gọi thử check với target = bottoms[0].
     *         6. Kết thúc cực kỳ tinh vi, lược bớt 80% số vòng quy quét.
     */
    public int minDominoRotations(int[] tops, int[] bottoms) {
        // Kiểm tra thử ứng cử viên ưu tiên tops[0]
        int res = check(tops, bottoms, tops[0]);

        // Nếu thành công hoặc 2 mặt con đầu bằng nhau (vậy có test mặt nào cũng hỏng
        // nếu res == -1)
        if (res != -1 || tops[0] == bottoms[0]) {
            return res;
        }

        // Cố gắng vớt vát ứng viên bottoms[0]
        return check(tops, bottoms, bottoms[0]);
    }

    private int check(int[] A, int[] B, int target) {
        int rotationsA = 0;
        int rotationsB = 0;

        for (int i = 0; i < A.length; i++) {
            // Không có giá trị target hiện diện tại domino vị trí i -> vô phương cứu chữa
            if (A[i] != target && B[i] != target) {
                return -1;
            }

            // Cần 1 lượt xoay để đưa target lên mặt Top
            if (A[i] != target) {
                rotationsA++;
            }
            // Cần 1 lượt xoay để đưa target xuống mặt Bottom
            else if (B[i] != target) {
                rotationsB++;
            }
        }

        // Chọn ra phương án cần ít lực xoay nhất
        return Math.min(rotationsA, rotationsB);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] tops1 = { 2, 1, 2, 4, 2, 2 };
        int[] bottoms1 = { 5, 2, 6, 2, 3, 2 };
        System.out.println("Result 1: " + sol.minDominoRotations(tops1, bottoms1)); // expected 2

        int[] tops2 = { 3, 5, 1, 2, 3 };
        int[] bottoms2 = { 3, 6, 3, 3, 4 };
        System.out.println("Result 2: " + sol.minDominoRotations(tops2, bottoms2)); // expected -1
    }
}
