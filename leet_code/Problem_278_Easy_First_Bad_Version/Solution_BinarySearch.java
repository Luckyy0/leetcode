package leet_code.Problem_278_Easy_First_Bad_Version;

// Mock class to simulate the API
class VersionControl {
    boolean isBadVersion(int version) {
        // Implementation hidden by LeetCode
        return version >= 4; // Mock logic
    }
}

public class Solution_BinarySearch extends VersionControl {

    /**
     * Finds the first bad version.
     * Uses Binary Search logic.
     * Time: O(log N), Space: O(1).
     * 
     * Tìm phiên bản lỗi đầu tiên.
     * Sử dụng logic Tìm kiếm Nhị phân.
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            // Prevent integer overflow
            // Ngăn chặn tràn số nguyên
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                // If mid is bad, the first bad version is at mid or before mid
                // Nếu mid bị lỗi, phiên bản lỗi đầu tiên nằm ở mid hoặc trước mid
                right = mid;
            } else {
                // If mid is good, the first bad version must be after mid
                // Nếu mid tốt, phiên bản lỗi đầu tiên phải nằm sau mid
                left = mid + 1;
            }
        }

        // left == right is the first bad version
        // left == right là phiên bản lỗi đầu tiên
        return left;
    }

    public static void main(String[] args) {
        Solution_BinarySearch solution = new Solution_BinarySearch();

        // Test Case: n=5, bad=4 -> 4 (Mocked in base class)
        System.out.println("First Bad: " + solution.firstBadVersion(5));
    }
}
