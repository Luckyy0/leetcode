package leet_code.Problem_274_Medium_H_Index;

public class Solution_Counting {

    /**
     * Calculates the H-Index.
     * Uses Counting Sort (Buckets).
     * Time: O(N), Space: O(N).
     * 
     * Tính toán Chỉ số H.
     * Sử dụng Sắp xếp Đếm (Buckets).
     */
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n + 1];

        // Populate buckets
        // Điền vào các bucket
        for (int c : citations) {
            if (c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }

        int count = 0;
        // Iterate from back to find max h
        // Duyệt ngược để tìm h lớn nhất
        for (int h = n; h >= 0; h--) {
            count += buckets[h];
            if (count >= h) {
                return h;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution_Counting solution = new Solution_Counting();

        // Test Case 1: [3,0,6,1,5] -> 3
        int[] c1 = { 3, 0, 6, 1, 5 };
        System.out.println("H-Index 1: " + solution.hIndex(c1));

        // Test Case 2: [1,3,1] -> 1
        int[] c2 = { 1, 3, 1 };
        System.out.println("H-Index 2: " + solution.hIndex(c2));
    }
}
