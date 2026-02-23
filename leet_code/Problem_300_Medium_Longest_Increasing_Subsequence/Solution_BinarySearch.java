package leet_code.Problem_300_Medium_Longest_Increasing_Subsequence;

import java.util.Arrays;

public class Solution_BinarySearch {

    /**
     * Finds the length of LIS.
     * Uses Patience Sorting algorithm (Binary Search on tails).
     * Time: O(N log N), Space: O(N).
     * 
     * Tìm độ dài của LIS.
     * Sử dụng thuật toán Sắp xếp Kiên nhẫn (Tìm kiếm nhị phân trên các đuôi).
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] tails = new int[nums.length];
        int len = 0;

        for (int x : nums) {
            // Check if x can extend the longest sequence found so far
            // Kiểm tra xem x có thể mở rộng chuỗi dài nhất tìm thấy cho đến nay không
            if (len == 0 || x > tails[len - 1]) {
                tails[len++] = x;
            } else {
                // If not, binary search for the smallest element <= x and replace it
                // Note: Arrays.binarySearch returns (-(insertion point) - 1) if not found
                // Nếu không, tìm kiếm nhị phân phần tử nhỏ nhất <= x và thay thế nó
                // Lưu ý: Arrays.binarySearch trả về (-(điểm chèn) - 1) nếu không tìm thấy

                // We want to find the first element >= x.
                // Arrays.binarySearch finds exact match or insertion point.

                int i = 0;
                int j = len;
                // Custom Binary Search to find insertion index 'i' such that tails[i] >= x
                // Tìm kiếm nhị phân tùy chỉnh để tìm chỉ số chèn 'i' sao cho tails[i] >= x
                while (i < j) {
                    int m = (i + j) / 2;
                    if (tails[m] < x) {
                        i = m + 1;
                    } else {
                        j = m;
                    }
                }
                // Replace the found element with x to maintain "smallest tail" property
                // Thay thế phần tử tìm thấy bằng x để duy trì tính chất "đuôi nhỏ nhất"
                tails[i] = x;
            }
        }

        return len;
    }

    public static void main(String[] args) {
        Solution_BinarySearch solution = new Solution_BinarySearch();

        // Test Case 1: [10,9,2,5,3,7,101,18] -> 4
        int[] n1 = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println("LIS 1: " + solution.lengthOfLIS(n1));

        // Test Case 2: [0,1,0,3,2,3] -> 4
        int[] n2 = { 0, 1, 0, 3, 2, 3 };
        System.out.println("LIS 2: " + solution.lengthOfLIS(n2));
    }
}
