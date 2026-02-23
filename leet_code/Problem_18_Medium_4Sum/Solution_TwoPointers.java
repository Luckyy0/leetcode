package leet_code.Problem_18_Medium_4Sum;

public class Solution_TwoPointers {

    static class MyArrayList<T> {
        Object[] elements;
        int size;

        public MyArrayList() {
            elements = new Object[10];
            size = 0;
        }

        public void add(T e) {
            if (size == elements.length) {
                Object[] newE = new Object[elements.length * 2];
                System.arraycopy(elements, 0, newE, 0, size);
                elements = newE;
            }
            elements[size++] = e;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < size; i++) {
                sb.append(elements[i]);
                if (i < size - 1)
                    sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }
    }

    /**
     * Finds unique quadruplets that sum to target.
     * Uses O(N^3) Time.
     * Tìm các bộ bốn duy nhất có tổng bằng target.
     * Sử dụng Thời gian O(N^3).
     */
    public MyArrayList<MyArrayList<Integer>> fourSum(int[] nums, int target) {
        quickSort(nums, 0, nums.length - 1);
        MyArrayList<MyArrayList<Integer>> result = new MyArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            // Duplicate check for i
            // Kiểm tra trùng lặp cho i
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            // Pruning: Logic to skip useless loops
            // Tỉa nhánh: Logic để bỏ qua các vòng lặp vô ích
            // If smallest sum > target, impossible
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                break;
            // If largest sum < target, impossible for this i
            if ((long) nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target)
                continue;

            for (int j = i + 1; j < n - 2; j++) {
                // Duplicate check for j
                // Kiểm tra trùng lặp cho j
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                // Pruning for j
                // Tỉa nhánh cho j
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target)
                    break;
                if ((long) nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target)
                    continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        MyArrayList<Integer> quad = new MyArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[left]);
                        quad.add(nums[right]);
                        result.add(quad);

                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        while (left < right && nums[right] == nums[right - 1])
                            right--;
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
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

    public static void main(String[] args) {
        Solution_TwoPointers solution = new Solution_TwoPointers();

        // Test Case 1
        int[] n1 = { 1, 0, -1, 0, -2, 2 };
        System.out.println("Test Case 1: " + solution.fourSum(n1, 0));

        // Test Case 2
        int[] n2 = { 2, 2, 2, 2, 2 };
        System.out.println("Test Case 2: " + solution.fourSum(n2, 8));
    }
}
