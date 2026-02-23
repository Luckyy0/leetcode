package Problem_1051_Easy_Height_Checker;

/**
 * 1051. Height Checker
 * 
 * A school is trying to take an annual photo of all the students.
 * The students are asked to stand in a single file line in non-decreasing order
 * by height.
 * You are given an integer array heights representing the current order that
 * the students are standing in.
 * Return the number of indices where heights[i] != expected[i].
 */
public class Solution {

    /**
     * Dùng Thuật toán Sắp xếp đếm (Counting Sort) vì giới hạn chiều cao rất nhỏ (từ
     * 1 đến 100).
     * Cách này giúp thuật toán chạy cực nhanh với O(N) thay vì O(N log N) nếu dùng
     * Arrays.sort().
     * 
     * @param heights Mảng chiều cao hiện tại của học sinh đang đứng lộn xộn
     * @return Số lượng học sinh đang đứng sai vị trí so với đội hình chuẩn
     */
    public int heightChecker(int[] heights) {
        // Mảng đếm tần suất xuất hiện của từng chiều cao (từ 1 đến 100)
        int[] frequencyScores = new int[101];

        // Bước 1: Quét 1 vòng để đếm số lượng học sinh có cùng một mốc chiều cao
        for (int h : heights) {
            frequencyScores[h]++;
        }

        int discrepancies = 0; // Biến lưu số lượng học sinh đứng sai chỗ
        int currentExpectedHeight = 1; // Chiều cao chuẩn bắt đầu xét từ mốc thấp nhất (1)

        // Bước 2: Quét lại mảng học sinh đang đứng thực tế để so khớp
        for (int actualHeightAtPos : heights) {

            // Tìm chiều cao chuẩn tiếp theo (Bỏ qua các mốc chiều cao không có học sinh
            // nào)
            while (frequencyScores[currentExpectedHeight] == 0) {
                currentExpectedHeight++;
            }

            // Nếu phát hiện chiều cao thực tế của đứa học sinh đang đứng ở vị trí này
            // KHÁC VỚI chiều cao đáng lẽ phải có (currentExpectedHeight)... Cấp thẻ phạt
            // lỗi!
            if (actualHeightAtPos != currentExpectedHeight) {
                discrepancies++;
            }

            // Mỗi lần xét xong, trừ đi 1 suất của mốc chiều cao chuẩn hiện tại
            frequencyScores[currentExpectedHeight]--;
        }

        return discrepancies;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] heights1 = { 1, 1, 4, 2, 1, 3 };
        System.out.println("Test 1: " + sol.heightChecker(heights1)); // Expected: 3

        int[] heights2 = { 5, 1, 2, 3, 4 };
        System.out.println("Test 2: " + sol.heightChecker(heights2)); // Expected: 5

        int[] heights3 = { 1, 2, 3, 4, 5 };
        System.out.println("Test 3: " + sol.heightChecker(heights3)); // Expected: 0
    }
}
