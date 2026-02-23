package leet_code.Problem_347_Medium_Top_K_Frequent_Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_BucketSort {

    /**
     * Finds top k frequent elements.
     * Uses Bucket Sort for O(N) time complexity.
     * Time: O(N), Space: O(N).
     * 
     * Tìm k phần tử thường xuyên nhất.
     * Sử dụng Sắp xếp theo Thùng để đạt độ phức tạp thời gian O(N).
     */
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Build frequency map
        // 1. Xây dựng bản đồ tần suất
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        // 2. Create buckets where index is frequency
        // 2. Tạo các thùng trong đó chỉ số là tần suất
        // Maximum possible frequency is nums.length
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }

        // 3. Collect top k elements from highest frequency
        // 3. Thu thập k phần tử hàng đầu từ tần suất cao nhất
        int[] result = new int[k];
        int count = 0;
        for (int pos = buckets.length - 1; pos >= 0 && count < k; pos--) {
            if (buckets[pos] != null) {
                for (int num : buckets[pos]) {
                    result[count++] = num;
                    if (count == k)
                        break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_BucketSort solution = new Solution_BucketSort();

        // Test Case 1: [1,1,1,2,2,3], k=2 -> [1,2]
        int[] r1 = solution.topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2);
        System.out.print("Result 1: ");
        for (int x : r1)
            System.out.print(x + " ");
        System.out.println();

        // Test Case 2: [1], k=1 -> [1]
        int[] r2 = solution.topKFrequent(new int[] { 1 }, 1);
        System.out.print("Result 2: ");
        for (int x : r2)
            System.out.print(x + " ");
        System.out.println();
    }
}
