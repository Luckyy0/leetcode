package leet_code.Problem_349_Easy_Intersection_Of_Two_Arrays;

import java.util.HashSet;
import java.util.Set;

public class Solution_Set {

    /**
     * Finds intersection of two arrays.
     * Uses HashSet for O(N + M) average time complexity.
     * Time: O(N + M), Space: O(min(N, M)).
     * 
     * Tìm phần giao của hai mảng.
     * Sử dụng HashSet để đạt độ phức tạp thời gian trung bình O(N + M).
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }

        Set<Integer> intersectionSet = new HashSet<>();
        for (int n : nums2) {
            if (set1.contains(n)) {
                intersectionSet.add(n);
            }
        }

        // Convert set to array
        // Chuyển tập hợp sang mảng
        int[] result = new int[intersectionSet.size()];
        int i = 0;
        for (int n : intersectionSet) {
            result[i++] = n;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_Set solution = new Solution_Set();

        // Test Case 1: [1,2,2,1], [2,2] -> [2]
        int[] r1 = solution.intersection(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 });
        System.out.print("Result 1: ");
        for (int x : r1)
            System.out.print(x + " ");
        System.out.println();

        // Test Case 2: [4,9,5], [9,4,9,8,4] -> [4, 9]
        int[] r2 = solution.intersection(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 });
        System.out.print("Result 2: ");
        for (int x : r2)
            System.out.print(x + " ");
        System.out.println();
    }
}
