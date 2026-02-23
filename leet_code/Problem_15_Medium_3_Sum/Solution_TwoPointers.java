package leet_code.Problem_15_Medium_3_Sum;

public class Solution_TwoPointers {

    /**
     * Custom generic List-like structure.
     * Cấu trúc giống List tùy chỉnh.
     */
    static class MyArrayList<T> {
        Object[] elements;
        int size;

        public MyArrayList() {
            elements = new Object[10];
            size = 0;
        }

        public void add(T element) {
            if (size == elements.length) {
                Object[] newElements = new Object[elements.length * 2];
                System.arraycopy(elements, 0, newElements, 0, size);
                elements = newElements;
            }
            elements[size++] = element;
        }

        @SuppressWarnings("unchecked")
        public T get(int index) {
            return (T) elements[index];
        }

        public int size() {
            return size;
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
     * Finds unique triplets that sum to zero.
     * Uses QuickSort and Two Pointers.
     * Tìm các bộ ba duy nhất có tổng bằng không.
     * Sử dụng QuickSort và Hai Con Trỏ.
     */
    public MyArrayList<MyArrayList<Integer>> threeSum(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        MyArrayList<MyArrayList<Integer>> result = new MyArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first number
            // Bỏ qua các phần tử trùng cho số đầu tiên
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    MyArrayList<Integer> triplet = new MyArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    result.add(triplet);

                    // Skip duplicates for the second number
                    // Bỏ qua các phần tử trùng cho số thứ hai
                    while (left < right && nums[left] == nums[left + 1])
                        left++;

                    // Skip duplicates for the third number
                    // Bỏ qua các phần tử trùng cho số thứ ba
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
        return result;
    }

    /**
     * QuickSort implementation.
     * Cài đặt QuickSort.
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
        int[] nums1 = { -1, 0, 1, 2, -1, -4 };
        System.out.println("Test Case 1: " + solution.threeSum(nums1));
        // Expected: [[-1, -1, 2], [-1, 0, 1]]

        // Test Case 2
        int[] nums2 = { 0, 1, 1 };
        System.out.println("Test Case 2: " + solution.threeSum(nums2));
        // Expected: []

        // Test Case 3
        int[] nums3 = { 0, 0, 0 };
        System.out.println("Test Case 3: " + solution.threeSum(nums3));
        // Expected: [[0, 0, 0]]
    }
}
