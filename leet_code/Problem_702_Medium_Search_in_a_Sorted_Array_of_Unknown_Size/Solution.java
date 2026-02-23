package leet_code.Problem_702_Medium_Search_in_a_Sorted_Array_of_Unknown_Size;

/**
 * Interface provided by LeetCode (Mocked here for compilation).
 */
interface ArrayReader {
    int get(int index);
}

public class Solution {

    /**
     * Finds the target in an array of unknown size in O(log T) time.
     * Strategy: Exponential search to find the upper bound, then binary search.
     * Time: O(log T), Space: O(1).
     */
    public int search(ArrayReader reader, int target) {
        // Step 1: Discover high boundary using exponential expansion
        int left = 0;
        int right = 1;
        while (reader.get(right) < target) {
            left = right;
            right <<= 1; // Double the range: O(log T)
        }

        // Step 2: Standard binary search within [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int num = reader.get(mid);

            if (num == target) {
                return mid;
            } else if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
