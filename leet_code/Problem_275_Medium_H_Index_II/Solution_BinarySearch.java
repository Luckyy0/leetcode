package leet_code.Problem_275_Medium_H_Index_II;

public class Solution_BinarySearch {

    /**
     * Calculates the H-Index for sorted citations.
     * Uses Binary Search.
     * Time: O(log N), Space: O(1).
     * 
     * Tính toán Chỉ số H cho các trích dẫn đã sắp xếp.
     * Sử dụng Tìm kiếm Nhị phân.
     */
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0;
        int high = n - 1;

        // Find the first index i such that citations[i] >= n - i
        // Tìm chỉ số i đầu tiên sao cho citations[i] >= n - i
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int h = n - mid;

            if (citations[mid] >= h) {
                // Compatible, but try to find a larger h (smaller mid)
                // Tương thích, nhưng cố gắng tìm h lớn hơn (mid nhỏ hơn)
                high = mid - 1;
            } else {
                // Not enough citations, need to look at right side (larger citations)
                // Không đủ trích dẫn, cần nhìn sang bên phải (trích dẫn lớn hơn)
                low = mid + 1;
            }
        }

        // low points to the first index where citations[low] >= n - low
        // Or n if no such index exists
        // low trỏ đến chỉ số đầu tiên nơi citations[low] >= n - low
        // Hoặc n nếu không có chỉ số nào như vậy
        return n - low;
    }

    public static void main(String[] args) {
        Solution_BinarySearch solution = new Solution_BinarySearch();

        // Test Case 1: [0,1,3,5,6] -> 3
        int[] c1 = { 0, 1, 3, 5, 6 };
        System.out.println("H-Index 1: " + solution.hIndex(c1));

        // Test Case 2: [1,2,100] -> 2
        int[] c2 = { 1, 2, 100 };
        System.out.println("H-Index 2: " + solution.hIndex(c2));
    }
}
