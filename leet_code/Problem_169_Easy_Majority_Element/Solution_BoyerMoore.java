package leet_code.Problem_169_Easy_Majority_Element;

public class Solution_BoyerMoore {

    /**
     * Finds the majority element using the Boyer-Moore Voting Algorithm.
     * Time: O(N), Space: O(1).
     * 
     * Tìm phần tử đa số sử dụng Thuật toán bỏ phiếu Boyer-Moore.
     * Thời gian: O(N), Không gian: O(1).
     */
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            // If count is 0, we pick the current number as the new candidate
            // Nếu count bằng 0, ta chọn số hiện tại làm ứng cử viên mới
            if (count == 0) {
                candidate = num;
                count = 1;
            }
            // If current number matches candidate, increment count
            // Nếu số hiện tại khớp với ứng cử viên, tăng count
            else if (num == candidate) {
                count++;
            }
            // Otherwise, decrement count (cancellation)
            // Ngược lại, giảm count (triệt tiêu)
            else {
                count--;
            }
        }

        // The problem assumes majority element always exists.
        return candidate;
    }

    public static void main(String[] args) {
        Solution_BoyerMoore solution = new Solution_BoyerMoore();

        // Test Case 1: [3,2,3] -> 3
        int[] n1 = { 3, 2, 3 };
        System.out.println("Test Case 1: " + solution.majorityElement(n1));

        // Test Case 2: [2,2,1,1,1,2,2] -> 2
        int[] n2 = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println("Test Case 2: " + solution.majorityElement(n2));
    }
}
