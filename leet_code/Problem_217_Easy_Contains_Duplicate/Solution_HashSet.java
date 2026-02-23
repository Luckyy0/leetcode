package leet_code.Problem_217_Easy_Contains_Duplicate;

import java.util.HashSet;
import java.util.Set;

public class Solution_HashSet {

    /**
     * Checks if the array contains any duplicate elements.
     * Uses a HashSet for O(N) time complexity.
     * 
     * Kiểm tra xem mảng có chứa bất kỳ phần tử trùng lặp nào không.
     * Sử dụng HashSet cho độ phức tạp thời gian O(N).
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            // If the set already contains the number, we found a duplicate
            // Nếu set đã chứa số đó, chúng ta đã tìm thấy bản sao
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_HashSet solution = new Solution_HashSet();

        // Test Case 1: [1,2,3,1] -> true
        int[] n1 = { 1, 2, 3, 1 };
        System.out.println("Contains Duplicate 1: " + solution.containsDuplicate(n1));

        // Test Case 2: [1,2,3,4] -> false
        int[] n2 = { 1, 2, 3, 4 };
        System.out.println("Contains Duplicate 2: " + solution.containsDuplicate(n2));

        // Test Case 3: [1,1,1,3,3,4,3,2,4,2] -> true
        int[] n3 = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
        System.out.println("Contains Duplicate 3: " + solution.containsDuplicate(n3));
    }
}
