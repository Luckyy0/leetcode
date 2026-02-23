package leet_code.Problem_187_Medium_Repeated_DNA_Sequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_HashSet {

    /**
     * Finds all 10-letter-long sequences that occur more than once.
     * Uses two HashSets to track seen and repeated sequences.
     * Time: O(N), Space: O(N).
     * 
     * Tìm tất cả các chuỗi dài 10 ký tự xuất hiện nhiều hơn một lần.
     * Sử dụng hai HashSet để theo dõi các chuỗi đã gặp và chuỗi lặp lại.
     */
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        // Sliding window of length 10
        // Cửa sổ trượt độ dài 10
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);

            // Set.add returns false if the element is already present
            // Set.add trả về false nếu phần tử đã tồn tại
            if (!seen.add(sub)) {
                repeated.add(sub);
            }
        }

        return new ArrayList<>(repeated);
    }

    public static void main(String[] args) {
        Solution_HashSet solution = new Solution_HashSet();

        // Test Case 1: "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
        String s1 = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println("Result 1: " + solution.findRepeatedDnaSequences(s1));

        // Test Case 2: "AAAAAAAAAAAAA"
        String s2 = "AAAAAAAAAAAAA";
        System.out.println("Result 2: " + solution.findRepeatedDnaSequences(s2));
    }
}
