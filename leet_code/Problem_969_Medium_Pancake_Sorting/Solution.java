package leet_code.Problem_969_Medium_Pancake_Sorting;

import java.util.*;

/**
 * Problem 969: Pancake Sorting
 * https://leetcode.com/problems/pancake-sorting/
 */
public class Solution {

    /**
     * Sorts the array using pancake flips.
     * Strategy: Iterate decreasingly to place largest elements at the end using 2
     * flips/element.
     * 
     * @param arr Array to sort.
     * @return List of k-values for flips.
     * 
     *         Tóm tắt chiến lược:
     *         1. Ý tưởng giống Selection Sort: Đưa phần tử lớn nhất về đúng vị trí
     *         ở cuối mảng, sau đó giảm kích thước bài toán và lặp lại.
     *         2. Để đưa phần tử có giá trị `x` (đang ở vị trí `i`) về vị trí cuối
     *         cùng `n-1` của phần chưa sắp xếp:
     *         - Bước 1: Lật `k = i + 1`. Thao tác này đảo ngược đoạn `0..i`, đưa
     *         phần tử `x` về đầu mảng (vị trí 0).
     *         - Bước 2: Lật `k = n`. Thao tác này đảo ngược đoạn `0..n-1`, đưa phần
     *         tử `x` từ đầu mảng về vị trí `n-1`.
     *         3. Lặp lại quá trình với `n` giảm dần từ độ dài mảng về 1.
     *         4. Tổng số lần lật tối đa là `2 * N`, thoả mãn điều kiện `10 * N`.
     */
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int n = arr.length;

        // Iterate backwards, placing largest elements first
        for (int value = n; value >= 1; value--) {
            int index = findIndex(arr, value);

            // If element is already at the correct position (index == value - 1), skip
            // Note: In a permutation of 1..N, the value 'V' should be at index 'V-1'
            if (index == value - 1) {
                continue;
            }

            // Step 1: Bring element to front (if not already there)
            if (index != 0) {
                result.add(index + 1);
                reverse(arr, index);
            }

            // Step 2: Bring element to its correct position (value - 1)
            // Currently element is at 0. We want it at (value - 1).
            // Flip the first 'value' elements.
            result.add(value);
            reverse(arr, value - 1);
        }

        return result;
    }

    // Finds the current index of the target value
    private int findIndex(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Reverses arr[0...k]
    private void reverse(int[] arr, int k) {
        int i = 0, j = k;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = { 3, 2, 4, 1 };
        System.out.println("Result: " + sol.pancakeSort(arr1));
        // Possible Output: [3, 4, 2, 3, 2] or [4, 2, 4, 3] etc.
        // Verifying logic implicitly.

        int[] arr2 = { 1, 2, 3 };
        System.out.println("Result: " + sol.pancakeSort(arr2)); // []
    }
}
