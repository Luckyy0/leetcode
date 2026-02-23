package leet_code.Problem_975_Hard_Odd_Even_Jump;

import java.util.Map;
import java.util.TreeMap;

/**
 * Problem 975: Odd Even Jump
 * https://leetcode.com/problems/odd-even-jump/
 */
public class Solution {

    /**
     * Finds the number of starting indices from which we can reach the end using
     * odd/even jumps.
     * Strategy: DP + TreeMap (Backwards).
     * 
     * @param arr Array of integers.
     * @return Number of good starting indices.
     * 
     *         Tóm tắt chiến lược:
     *         1. Ta cần xác định với mỗi vị trí `i`, liệu ta có thể đến đích `n-1`
     *         hay không.
     *         2. Nhận xét: Bước nhảy phụ thuộc vào giá trị các phần tử phía sau.
     *         - Bước nhảy lẻ (lần 1, 3, 5...): Tìm giá trị nhỏ nhất `v >= arr[i]` ở
     *         bên phải. (Dùng `ceilingEntry`).
     *         - Bước nhảy chẵn (lần 2, 4, 6...): Tìm giá trị lớn nhất `v <= arr[i]`
     *         ở bên phải. (Dùng `floorEntry`).
     *         3. Do ta cần thông tin của các bước nhảy trong tương lai để quyết
     *         định hiện tại, ta nên duyệt ngược từ cuối mảng về đầu.
     *         4. Sử dụng `TreeMap` để lưu trữ `(giá trị -> chỉ số)` của các phần tử
     *         đã duyệt (nằm bên phải `i`).
     *         TreeMap cho phép tìm kiếm `ceiling` và `floor` trong O(log N).
     *         5. Quy hoạch động (DP):
     *         - `odd[i]`: Có thể đến đích từ `i` nếu bắt đầu bằng bước nhảy lẻ
     *         không?
     *         - `even[i]`: Có thể đến đích từ `i` nếu bắt đầu bằng bước nhảy chẵn
     *         không?
     *         - Công thức truy hồi:
     *         `odd[i] = even[next_odd_jump_index]`
     *         `even[i] = odd[next_even_jump_index]`
     *         6. Khởi tạo: Tại `n-1`, ta luôn đến đích. `odd[n-1] = even[n-1] =
     *         true`.
     *         7. Kết quả là số lượng `i` mà `odd[i]` là true (vì bước nhảy đầu tiên
     *         luôn là lẻ).
     */
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return n;
        }

        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];

        // Base case: The last element is always reachable from itself
        odd[n - 1] = true;
        even[n - 1] = true;

        // Map stores value -> index
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[n - 1], n - 1);

        int goodIndices = 1; // Last index is always good

        // Iterate backwards
        for (int i = n - 2; i >= 0; i--) {
            int val = arr[i];

            // Odd Jump: Find smallest value >= val
            Map.Entry<Integer, Integer> ceiling = map.ceilingEntry(val);
            if (ceiling != null) {
                // Next state will be an even jump from the found index
                odd[i] = even[ceiling.getValue()];
            }

            // Even Jump: Find largest value <= val
            Map.Entry<Integer, Integer> floor = map.floorEntry(val);
            if (floor != null) {
                // Next state will be an odd jump from the found index
                even[i] = odd[floor.getValue()];
            }

            // Add current element to map
            // Since we iterate backwards, this index 'i' is smaller than any existing index
            // for the same value 'val'.
            // The problem requires jumping to the *smallest* index.
            // So overwriting map.put(val, i) is correct because subsequent (smaller i)
            // queries will find this 'i' as the smallest index to their right.
            map.put(val, i);

            // If we can start an odd jump from here and reach end, count it.
            if (odd[i]) {
                goodIndices++;
            }
        }

        return goodIndices;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] result1 = { 10, 13, 12, 14, 15 };
        System.out.println("Result: " + sol.oddEvenJumps(result1)); // 2

        int[] result2 = { 2, 3, 1, 1, 4 };
        System.out.println("Result: " + sol.oddEvenJumps(result2)); // 3

        int[] result3 = { 5, 1, 3, 4, 2 };
        System.out.println("Result: " + sol.oddEvenJumps(result3)); // 3
    }
}
