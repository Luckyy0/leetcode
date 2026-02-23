package leet_code.Problem_949_Medium_Largest_Time_for_Given_Digits;

/**
 * Problem 949: Largest Time for Given Digits
 * https://leetcode.com/problems/largest-time-for-given-digits/
 */
public class Solution {

    /**
     * Finds the largest valid 24-hour time that can be formed from the given
     * digits.
     * Strategy: Permutations.
     * 
     * @param arr Array of 4 digits.
     * @return Largest valid time in "HH:MM" format or empty string.
     * 
     *         Tóm tắt chiến lược:
     *         1. Vì chỉ có 4 chữ số, số lượng hoán vị rất nhỏ (4! = 24).
     *         2. Ta có thể duyệt qua tất cả các hoán vị có thể của 4 chữ số này.
     *         3. Với mỗi hoán vị, ta tạo thành giờ (2 chữ số đầu) và phút (2 chữ số
     *         sau).
     *         4. Kiểm tra xem giờ có hợp lệ (< 24) và phút có hợp lệ (< 60) hay
     *         không.
     *         5. Nếu hợp lệ, ta chuyển đổi thời gian đó thành tổng số phút kể từ
     *         00:00 (giờ * 60 + phút) để dễ dàng so sánh.
     *         6. Lưu lại giá trị thời gian lớn nhất tìm được.
     *         7. Cuối cùng, định dạng lại thành chuỗi "HH:MM". Nếu không tìm được
     *         thời gian hợp lệ, trả về chuỗi rỗng.
     */
    public String largestTimeFromDigits(int[] arr) {
        int maxTotalMinutes = -1;

        // Permute through indices i, j, k.
        // Since indices are 0, 1, 2, 3, sum is 6. So l = 6 - i - j - k.
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == i)
                    continue; // Indices must be distinct
                for (int k = 0; k < 4; k++) {
                    if (k == i || k == j)
                        continue; // Indices must be distinct

                    int l = 6 - i - j - k; // The remaining index

                    // Form hours and minutes
                    int hours = arr[i] * 10 + arr[j];
                    int minutes = arr[k] * 10 + arr[l];

                    // Check validity
                    if (hours < 24 && minutes < 60) {
                        int totalMinutes = hours * 60 + minutes;
                        if (totalMinutes > maxTotalMinutes) {
                            maxTotalMinutes = totalMinutes;
                        }
                    }
                }
            }
        }

        if (maxTotalMinutes == -1) {
            return "";
        }

        // Format output
        return String.format("%02d:%02d", maxTotalMinutes / 60, maxTotalMinutes % 60);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = { 1, 2, 3, 4 };
        System.out.println("Result: " + sol.largestTimeFromDigits(arr1)); // "23:41"

        int[] arr2 = { 5, 5, 5, 5 };
        System.out.println("Result: " + sol.largestTimeFromDigits(arr2)); // ""

        int[] arr3 = { 0, 0, 0, 0 };
        System.out.println("Result: " + sol.largestTimeFromDigits(arr3)); // "00:00"

        int[] arr4 = { 0, 0, 1, 0 };
        System.out.println("Result: " + sol.largestTimeFromDigits(arr4)); // "10:00"
    }
}
