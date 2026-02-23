package leet_code.Problem_247_Medium_Strobogrammatic_Number_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_Recursion {

    /**
     * Generates all strobogrammatic numbers of length n.
     * Uses Recursion from inside out.
     * Time: O(5^(N/2)), Space: O(N) stack.
     * 
     * Tạo tất cả các số strobogrammatic có độ dài n.
     * Sử dụng Đệ quy từ trong ra ngoài.
     */
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    private List<String> helper(int n, int finalLength) {
        // Base case: n = 0 -> empty string
        // Trường hợp cơ sở: n = 0 -> chuỗi rỗng
        if (n == 0) {
            return new ArrayList<>(Arrays.asList(""));
        }

        // Base case: n = 1 -> "0", "1", "8"
        // Trường hợp cơ sở: n = 1 -> "0", "1", "8"
        if (n == 1) {
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        }

        // Recursive step: get list for n-2
        // Bước đệ quy: lấy danh sách cho n-2
        List<String> list = helper(n - 2, finalLength);
        List<String> res = new ArrayList<>();

        for (String s : list) {
            // Add pairs 1..1, 6..9, 8..8, 9..6
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");

            // Only add 0..0 if it's NOT the final outer layer
            // Chỉ thêm 0..0 nếu nó KHÔNG PHẢI là lớp ngoài cùng
            if (n != finalLength) {
                res.add("0" + s + "0");
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_Recursion solution = new Solution_Recursion();

        // Test Case 1: n = 2 -> ["11","69","88","96"]
        System.out.println("Result 1: " + solution.findStrobogrammatic(2));

        // Test Case 2: n = 1 -> ["0","1","8"]
        System.out.println("Result 2: " + solution.findStrobogrammatic(1));
    }
}
