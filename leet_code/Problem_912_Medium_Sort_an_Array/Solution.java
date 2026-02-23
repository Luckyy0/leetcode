package leet_code.Problem_912_Medium_Sort_an_Array;

/**
 * Problem 912: Sort an Array
 * https://leetcode.com/problems/sort-an-array/
 */
public class Solution {

    /**
     * Sorts the array in ascending order.
     * Strategy: Merge Sort (O(N log N) time, O(N) space).
     * 
     * @param nums Input array.
     * @return Sorted array.
     * 
     *         Tóm tắt chiến lược:
     *         1. Sử dụng thuật toán Merge Sort (Sắp xếp Trộn).
     *         2. Thuật toán này sử dụng chiến lược Chia để Trị (Divide and
     *         Conquer).
     *         3. Chia mảng thành hai nửa bằng nhau đến khi chỉ còn 1 phần tử.
     *         4. Trộn (Merge) đệ quy hai nửa đã sắp xếp lại với nhau để tạo thành
     *         mảng sắp xếp lớn hơn.
     *         5. Đây là thuật toán ổn định và đảm bảo thời gian chạy O(N log N)
     *         trong mọi trường hợp.
     */
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        merge(nums, left, mid, right, temp);
    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        // Copy data to temporary array
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        // Merge the two halves back into the original array
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                nums[k++] = temp[i++];
            } else {
                nums[k++] = temp[j++];
            }
        }

        // Copy remaining elements of left half if any
        while (i <= mid) {
            nums[k++] = temp[i++];
        }
        // No need to copy right half because it's already in place
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = { 5, 2, 3, 1 };
        int[] res1 = sol.sortArray(nums1);
        System.out.print("Result: ");
        for (int n : res1)
            System.out.print(n + " ");
        System.out.println(); // 1 2 3 5

        int[] nums2 = { 5, 1, 1, 2, 0, 0 };
        int[] res2 = sol.sortArray(nums2);
        System.out.print("Result: ");
        for (int n : res2)
            System.out.print(n + " ");
        System.out.println(); // 0 0 1 1 2 5
    }
}
