package leet_code.Problem_658_Medium_Find_K_Closest_Elements;

import java.util.*;

public class Solution_BinarySearchWindow {

    /**
     * Finds k closest elements to x in a sorted array.
     * Strategy: Binary search for the starting index of the window of size k.
     * Time: O(log(N-K) + K), Space: O(1).
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - k;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // We compare x's distance to arr[mid] and arr[mid + k]
            // If x is closer to arr[mid + k], move window to the right
            // Use (x - arr[mid]) vs (arr[mid + k] - x)
            if (x - arr[mid] > arr[mid + k] - x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        // Build result from low to low + k
        List<Integer> res = new ArrayList<>();
        for (int i = low; i < low + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_BinarySearchWindow sol = new Solution_BinarySearchWindow();
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println("Result (k=4, x=3): " + sol.findClosestElements(arr, 4, 3)); // [1, 2, 3, 4]
        System.out.println("Result (k=4, x=-1): " + sol.findClosestElements(arr, 4, -1)); // [1, 2, 3, 4]
    }
}
