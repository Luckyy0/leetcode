package leet_code.Problem_978_Medium_Longest_Turbulent_Subarray;

/**
 * Problem 978: Longest Turbulent Subarray
 * https://leetcode.com/problems/longest-turbulent-subarray/
 */
public class Solution {

    /**
     * Finds the length of the longest turbulent subarray.
     * Strategy: Sliding Window / Linear Scan.
     * 
     * @param arr Array of integers.
     * @return Max length.
     * 
     *         Tóm tắt chiến lược:
     *         1. Một mảng con hỗn loạn nếu dấu so sánh giữa các phần tử liền kề
     *         thay đổi liên tục (`> < > < ...`).
     *         2. Sử dụng chiến lược cửa sổ trượt (Sliding Window) hoặc quét tuyến
     *         tính.
     *         Duyệt qua mảng với biến `start` đánh dấu điểm bắt đầu của mảng con
     *         hỗn loạn hiện tại.
     *         3. Tại mỗi bước `i` (xét cặp `arr[i-1]` và `arr[i]`):
     *         - So sánh `c = compare(arr[i-1], arr[i])`.
     *         - Nếu `c == 0` (hai phần tử bằng nhau): Mảng con hỗn loạn bị ngắt
     *         hoàn toàn.
     *         Điểm bắt đầu mới `start` sẽ là `i` (để xét cặp tiếp theo `i, i+1`).
     *         - Nếu `i >= 2` và dấu so sánh `c` giống hệt dấu so sánh trước đó
     *         `prevC` (ví dụ `5 > 3 > 1`):
     *         Mảng con hỗn loạn bị ngắt, nhưng cặp hiện tại (`arr[i-1], arr[i]`)
     *         vẫn hợp lệ đê bắt đầu một chuỗi mới.
     *         Điểm bắt đầu mới `start` sẽ là `i - 1`.
     *         4. Cập nhật `maxLen = max(maxLen, i - start + 1)`.
     *         Lưu ý: Công thức độ dài `i - start + 1` tính số phần tử trong đoạn
     *         `[start, i]`.
     *         5. Trả về `maxLen`.
     */
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int maxLen = 1;
        int start = 0;

        for (int i = 1; i < n; i++) {
            int c = Integer.compare(arr[i - 1], arr[i]);

            if (c == 0) {
                // Elements are equal, breaks turbulence completely
                // Start next potential subarray at i
                start = i;
            } else if (i >= 2) {
                int prevC = Integer.compare(arr[i - 2], arr[i - 1]);
                // If directions are same (both increasing or both decreasing), break
                if ((c > 0 && prevC > 0) || (c < 0 && prevC < 0)) {
                    // Current pair is valid, but doesn't continue previous pattern
                    // Start new subarray at i-1
                    start = i - 1;
                }
            }

            // Current length is from start to i inclusive
            maxLen = Math.max(maxLen, i - start + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] result1 = { 9, 4, 2, 10, 7, 8, 8, 1, 9 };
        System.out.println("Result: " + sol.maxTurbulenceSize(result1)); // 5 (4, 2, 10, 7, 8)

        int[] result2 = { 4, 8, 12, 16 };
        System.out.println("Result: " + sol.maxTurbulenceSize(result2)); // 2

        int[] result3 = { 100 };
        System.out.println("Result: " + sol.maxTurbulenceSize(result3)); // 1
    }
}
