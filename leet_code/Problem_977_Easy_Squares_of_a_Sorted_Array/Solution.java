package leet_code.Problem_977_Easy_Squares_of_a_Sorted_Array;

/**
 * Problem 977: Squares of a Sorted Array
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 */
public class Solution {

    /**
     * Squares and sorts the array.
     * Strategy: Two Pointers from ends.
     * 
     * @param nums Sorted array.
     * @return Sorted squared array.
     * 
     *         Tóm tắt chiến lược:
     *         1. Mảng đầu vào đã được sắp xếp nhưng có thể chứa số âm.
     *         Bình phương của số âm có giá trị tuyệt đối lớn sẽ trở thành số lớn.
     *         Các phần tử có bình phương lớn nhất sẽ nằm ở hai đầu của mảng (âm lớn
     *         nhất hoặc dương lớn nhất).
     *         2. Sử dụng hai con trỏ `left` (bắt đầu từ 0) và `right` (bắt đầu từ
     *         n-1).
     *         3. So sánh giá trị tuyệt đối của `nums[left]` và `nums[right]`.
     *         Phần tử nào có trị tuyệt đối lớn hơn thì bình phương của nó sẽ lớn
     *         hơn.
     *         Ta đưa bình phương đó vào vị trí cuối cùng của mảng kết quả đang
     *         trống (`index` giảm dần từ n-1 về 0).
     *         4. Di chuyển con trỏ tương ứng (`left++` hoặc `right--`).
     *         5. Lặp lại cho đến khi điền hết mảng kết quả.
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int left = 0;
        int right = n - 1;
        int index = n - 1; // Fill from the end

        while (left <= right) {
            int leftAbs = Math.abs(nums[left]);
            int rightAbs = Math.abs(nums[right]);

            if (leftAbs > rightAbs) {
                result[index] = leftAbs * leftAbs;
                left++;
            } else {
                result[index] = rightAbs * rightAbs;
                right--;
            }
            index--;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] n1 = { -4, -1, 0, 3, 10 };
        int[] res1 = sol.sortedSquares(n1);
        System.out.print("Result: [");
        for (int i : res1)
            System.out.print(i + " "); // [0, 1, 9, 16, 100]
        System.out.println("]");

        int[] n2 = { -7, -3, 2, 3, 11 };
        int[] res2 = sol.sortedSquares(n2);
        System.out.print("Result: [");
        for (int i : res2)
            System.out.print(i + " "); // [4, 9, 9, 49, 121]
        System.out.println("]");
    }
}
