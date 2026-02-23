package leet_code.Problem_153_Medium_Find_Minimum_In_Rotated_Sorted_Array;

public class Solution_BinarySearch {

    /**
     * Finds the minimum element in a unique rotated sorted array in O(log N).
     * 
     * Tìm phần tử nhỏ nhất trong mảng đã sắp xếp bị xoay (các phần tử duy nhất)
     * với độ phức tạp thời gian O(log N).
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0;
        int right = nums.length - 1;

        // Binary Search loop
        // Vòng lặp tìm kiếm nhị phân
        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than right element, the minimum is in the right
            // half
            // Nếu phần tử ở giữa lớn hơn phần tử bên phải, giá trị nhỏ nhất nằm ở nửa bên
            // phải
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            // Otherwise, the minimum is either at mid or to the left of mid
            // Ngược lại, giá trị nhỏ nhất có thể là mid hoặc nằm bên trái mid
            else {
                right = mid;
            }
        }

        // When left == right, we have found the minimum element
        // Khi left == right, chúng ta đã tìm thấy phần tử nhỏ nhất
        return nums[left];
    }

    public static void main(String[] args) {
        Solution_BinarySearch solution = new Solution_BinarySearch();

        // Test Case 1: [3,4,5,1,2] -> 1
        int[] n1 = { 3, 4, 5, 1, 2 };
        System.out.println("Test Case 1: " + solution.findMin(n1));

        // Test Case 2: [4,5,6,7,0,1,2] -> 0
        int[] n2 = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println("Test Case 2: " + solution.findMin(n2));

        // Test Case 3: [11,13,15,17] -> 11
        int[] n3 = { 11, 13, 15, 17 };
        System.out.println("Test Case 3: " + solution.findMin(n3));
    }
}
