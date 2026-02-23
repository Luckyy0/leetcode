package leet_code.Problem_315_Hard_Count_Of_Smaller_Numbers_After_Self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_MergeSort {

    private static class Item {
        int val;
        int index;

        Item(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    private int[] counts;

    /**
     * Counts smaller numbers after self.
     * Uses Modified Merge Sort.
     * Time: O(N log N), Space: O(N).
     * 
     * Đếm các số nhỏ hơn phía sau.
     * Sử dụng Sắp xếp Trộn sửa đổi.
     */
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        counts = new int[n];
        List<Integer> result = new ArrayList<>();

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(nums[i], i);
        }

        mergeSort(items, 0, n - 1);

        for (int c : counts) {
            result.add(c);
        }
        return result;
    }

    // Sorts items in range [low, high] and updates counts
    private void mergeSort(Item[] items, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;
        mergeSort(items, low, mid);
        mergeSort(items, mid + 1, high);

        merge(items, low, mid, high);
    }

    private void merge(Item[] items, int low, int mid, int high) {
        Item[] temp = new Item[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;
        int rightCounter = 0; // Number of elements from right subarray jumped to left

        while (left <= mid && right <= high) {
            // Compare values. We want Ascending order.
            // If right element is smaller, it 'jumps' over current left elements
            // So it contributes to the 'smaller right' count.
            // Nếu phần tử bên phải nhỏ hơn, nó 'nhảy' qua các phần tử bên trái hiện tại
            // Vì vậy nó đóng góp vào số lượng 'nhỏ hơn bên phải'.
            if (items[right].val < items[left].val) {
                rightCounter++;
                temp[k++] = items[right++];
            } else {
                // items[left] <= items[right]
                // Current left element is placed.
                // All 'rightCounter' elements previously placed from right are smaller than it.
                // Phần tử bên trái hiện tại được đặt.
                // Tất cả 'rightCounter' phần tử đã đặt từ bên phải trước đó đều nhỏ hơn nó.
                counts[items[left].index] += rightCounter;
                temp[k++] = items[left++];
            }
        }

        while (left <= mid) {
            counts[items[left].index] += rightCounter;
            temp[k++] = items[left++];
        }

        while (right <= high) {
            temp[k++] = items[right++];
        }

        // Copy back
        for (int i = 0; i < temp.length; i++) {
            items[low + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        Solution_MergeSort solution = new Solution_MergeSort();

        // Test Case 1: [5,2,6,1] -> [2,1,1,0]
        int[] n1 = { 5, 2, 6, 1 };
        System.out.println("Counts 1: " + solution.countSmaller(n1));

        // Test Case 2: [-1] -> [0]
        int[] n2 = { -1 };
        System.out.println("Counts 2: " + solution.countSmaller(n2));
    }
}
