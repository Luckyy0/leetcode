package leet_code.Problem_179_Medium_Largest_Number;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_CustomSort {

    /**
     * Forms the largest number by arranging a list of integers.
     * Uses a custom comparator (s1 + s2) vs (s2 + s1).
     * Time: O(N log N * K), Space: O(N * K).
     * 
     * Tạo số lớn nhất bằng cách sắp xếp danh sách các số nguyên.
     * Sử dụng bộ so sánh tùy chỉnh (s1 + s2) so với (s2 + s1).
     */
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";

        // 1. Convert integers to strings
        // 1. Chuyển đổi số nguyên thành chuỗi
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // 2. Sort using custom comparator
        // 2. Sắp xếp bằng bộ so sánh tùy chỉnh
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String order1 = s1 + s2;
                String order2 = s2 + s1;
                // Descending order sort
                return order2.compareTo(order1);
            }
        });

        // 3. Handle edge case: if the largest number is "0", the entire result is "0"
        // 3. Xử lý trường hợp biên: nếu số lớn nhất là "0", toàn bộ kết quả là "0"
        if (strs[0].equals("0")) {
            return "0";
        }

        // 4. Join and return
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution_CustomSort solution = new Solution_CustomSort();

        // Test Case 1: [10, 2] -> "210"
        int[] n1 = { 10, 2 };
        System.out.println("Result 1: " + solution.largestNumber(n1));

        // Test Case 2: [3, 30, 34, 5, 9] -> "9534330"
        int[] n2 = { 3, 30, 34, 5, 9 };
        System.out.println("Result 2: " + solution.largestNumber(n2));

        // Test Case 3: [0, 0] -> "0"
        int[] n3 = { 0, 0 };
        System.out.println("Result 3: " + solution.largestNumber(n3));
    }
}
