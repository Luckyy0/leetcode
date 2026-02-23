package leet_code.Problem_16_Medium_3Sum_Closest;

public class Solution_TwoPointers {

    /**
     * Finds the triplet sum closest to the target.
     * Uses Sorting and Two Pointers approach.
     * Tìm tổng bộ ba gần nhất với target.
     * Sử dụng phương pháp Sắp xếp và Hai Con Trỏ.
     */
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array first
        // Sắp xếp mảng trước
        quickSort(nums, 0, nums.length - 1);

        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            // Optimization: Skip duplicates for i
            // Tối ưu hóa: Bỏ qua các phần tử trùng cho i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // If identical sum found, return immediately
                // Nếu tìm thấy tổng giống hệt, trả về ngay lập tức
                if (currentSum == target) {
                    return currentSum;
                }

                // Check absolute difference
                // Kiểm tra chênh lệch tuyệt đối
                if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
                    closestSum = currentSum;
                }

                if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
    }

    /**
     * Basic QuickSort implementation.
     * Cài đặt QuickSort cơ bản.
     */
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_TwoPointers solution = new Solution_TwoPointers();

        // Test Case 1
        int[] nums1 = { -1, 2, 1, -4 };
        int t1 = 1;
        System.out.println("Test Case 1: " + solution.threeSumClosest(nums1, t1));
        // Expected: 2

        // Test Case 2
        int[] nums2 = { 0, 0, 0 };
        int t2 = 1;
        System.out.println("Test Case 2: " + solution.threeSumClosest(nums2, t2));
        // Expected: 0
    }
}
