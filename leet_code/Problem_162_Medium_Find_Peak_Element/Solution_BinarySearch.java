package leet_code.Problem_162_Medium_Find_Peak_Element;

public class Solution_BinarySearch {

    /**
     * Finds a peak element in an array in O(log N) time.
     * A peak is greater than its immediate neighbors.
     * 
     * Tìm một phần tử cực đại trong mảng với thời gian O(log N).
     * Một cực đại lớn hơn các phần tử lân cận trực tiếp của nó.
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check the slope at mid
            // Kiểm tra độ dốc tại mid
            if (nums[mid] < nums[mid + 1]) {
                // Upward slope: a peak must be to the right
                // Độ dốc đi lên: cực đại phải nằm ở bên phải
                left = mid + 1;
            } else {
                // Downward slope: a peak is at mid or to the left
                // Độ dốc đi xuống: cực đại ở tại mid hoặc bên trái
                right = mid;
            }
        }

        // When left == right, we are on a peak
        return left;
    }

    public static void main(String[] args) {
        Solution_BinarySearch solution = new Solution_BinarySearch();

        // Test Case 1: [1,2,3,1] -> 2
        int[] n1 = { 1, 2, 3, 1 };
        System.out.println("Test Case 1 Index: " + solution.findPeakElement(n1));

        // Test Case 2: [1,2,1,3,5,6,4] -> 1 or 5
        int[] n2 = { 1, 2, 1, 3, 5, 6, 4 };
        System.out.println("Test Case 2 Index: " + solution.findPeakElement(n2));
    }
}
