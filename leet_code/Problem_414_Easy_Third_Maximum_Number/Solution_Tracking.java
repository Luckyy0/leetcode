package leet_code.Problem_414_Easy_Third_Maximum_Number;

public class Solution_Tracking {

    /**
     * Finds the third distinct maximum number.
     * Uses three variables to track top 3.
     * Time: O(N), Space: O(1).
     * 
     * Tìm số lớn thứ ba khác biệt.
     * Sử dụng ba biến để theo dõi top 3.
     */
    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;

        for (Integer num : nums) {
            // Avoid duplicates
            if (num.equals(max1) || num.equals(max2) || num.equals(max3))
                continue;

            if (max1 == null || num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (max2 == null || num > max2) {
                max3 = max2;
                max2 = num;
            } else if (max3 == null || num > max3) {
                max3 = num;
            }
        }

        return (max3 == null) ? max1 : max3;
    }

    public static void main(String[] args) {
        Solution_Tracking solution = new Solution_Tracking();

        // Test Case 1: [3, 2, 1] -> 1
        System.out.println("Result [3,2,1]: " + solution.thirdMax(new int[] { 3, 2, 1 }));

        // Test Case 2: [1, 2] -> 2
        System.out.println("Result [1,2]: " + solution.thirdMax(new int[] { 1, 2 }));

        // Test Case 3: [2, 2, 3, 1] -> 1
        System.out.println("Result [2,2,3,1]: " + solution.thirdMax(new int[] { 2, 2, 3, 1 }));
    }
}
