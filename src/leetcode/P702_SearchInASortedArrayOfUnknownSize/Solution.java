package leetcode.P702_SearchInASortedArrayOfUnknownSize;

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 * public int get(int index);
 * }
 */
interface ArrayReader {
    int get(int index);
}

class Solution {
    public int search(ArrayReader reader, int target) {
        // Find the range [left, right]
        // Tìm phạm vi [left, right]
        int left = 0;
        int right = 1;
        while (reader.get(right) < target) {
            left = right;
            right <<= 1; // Double the right index
        }

        // Binary search within the determined range
        // Tìm kiếm nhị phân trong phạm vi đã xác định
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int num = reader.get(mid);

            if (num == target)
                return mid;
            if (num > target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return -1;
    }
}
