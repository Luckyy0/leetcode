package leet_code.Problem_350_Easy_Intersection_Of_Two_Arrays_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_HashMap {

    /**
     * Finds intersection of two arrays with duplicate elements.
     * Uses HashMap for O(N + M) time complexity.
     * Time: O(N + M), Space: O(min(N, M)).
     * 
     * Tìm phần giao của hai mảng với các phần tử trùng lặp.
     * Sử dụng HashMap để đạt độ phức tạp thời gian O(N + M).
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        // Optimize: always use map for smaller array to save space
        // Tối ưu hóa: luôn dùng bản đồ cho mảng nhỏ hơn để tiết kiệm không gian
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> intersection = new ArrayList<>();
        for (int n : nums2) {
            if (map.containsKey(n) && map.get(n) > 0) {
                intersection.add(n);
                map.put(n, map.get(n) - 1);
            }
        }

        // Convert list to array
        // Chuyển danh sách sang mảng
        int[] result = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_HashMap solution = new Solution_HashMap();

        // Test Case 1: [1,2,2,1], [2,2] -> [2, 2]
        int[] r1 = solution.intersect(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 });
        System.out.print("Result 1: ");
        for (int x : r1)
            System.out.print(x + " ");
        System.out.println();

        // Test Case 2: [4,9,5], [9,4,9,8,4] -> [4, 9] (or [9, 4])
        int[] r2 = solution.intersect(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 });
        System.out.print("Result 2: ");
        for (int x : r2)
            System.out.print(x + " ");
        System.out.println();
    }
}
