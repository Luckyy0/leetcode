package leet_code.Problem_868_Easy_Binary_Gap;

/**
 * Problem 868: Binary Gap
 * https://leetcode.com/problems/binary-gap/
 */
public class Solution {

    /**
     * Calculates the longest distance between adjacent 1's in binary
     * representation.
     * Strategy: Iterate through bits using bitwise shifts and track the previous 1
     * position.
     * 
     * @param n Positive integer.
     * @return Max gap length or 0.
     * 
     *         Tóm tắt chiến lược:
     *         Chúng ta dùng vòng lặp di chuyển qua từng vị trí bit của số n (32
     *         bit).
     *         Sử dụng biến lastPos để lưu vị trí của số 1 gặp gần nhất.
     *         Mỗi khi gặp số 1 mới, nếu đã có số 1 trước đó, ta tính khoảng cách
     *         và cập nhật giá trị lớn nhất.
     */
    public int binaryGap(int n) {
        int maxGap = 0;
        int lastPos = -1;

        for (int i = 0; i < 32; i++) {
            // Check if the bit at position i is 1
            if (((n >> i) & 1) == 1) {
                if (lastPos != -1) {
                    // Calculate distance from previous 1
                    maxGap = Math.max(maxGap, i - lastPos);
                }
                // Record the current position
                lastPos = i;
            }
        }

        return maxGap;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Max Gap: " + sol.binaryGap(22)); // 2
        System.out.println("Max Gap: " + sol.binaryGap(8)); // 0
        System.out.println("Max Gap: " + sol.binaryGap(5)); // 2
    }
}
