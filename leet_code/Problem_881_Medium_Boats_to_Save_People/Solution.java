package leet_code.Problem_881_Medium_Boats_to_Save_People;

import java.util.*;

/**
 * Problem 881: Boats to Save People
 * https://leetcode.com/problems/boats-to-save-people/
 */
public class Solution {

    /**
     * Calculates the minimum number of boats required.
     * Strategy: Greedy with two pointers.
     * Always try to pair the heaviest person with the lightest.
     * 
     * @param people Array of weights.
     * @param limit  Maximum weight per boat.
     * @return Number of boats.
     * 
     *         Tóm tắt chiến lược:
     *         1. Sắp xếp mảng cân nặng theo thứ tự tăng dần.
     *         2. Sử dụng 2 con trỏ:
     *         - 'i' trỏ vào người nhẹ nhất (đầu mảng).
     *         - 'j' trỏ vào người nặng nhất (cuối mảng).
     *         3. Mỗi lượt, chúng ra CHẮC CHẮN phải đưa người nặng nhất 'j' đi.
     *         Câu hỏi là: có thể kẹp thêm người nhẹ nhất 'i' đi cùng không?
     *         4. Nếu people[i] + people[j] <= limit, thì cả hai đi cùng. Tăng 'i',
     *         giảm 'j'.
     *         (lấy người nặng nhất ghép với người nhẹ nhất).
     *         5. Nếu không (tổng > limit), người nặng nhất đi một mình. Chỉ giảm
     *         'j'.
     *         6. Mỗi bước đều tốn 1 thuyền. Làm đến khi hết người.
     */
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int boats = 0;

        while (i <= j) {
            boats++;
            if (people[i] + people[j] <= limit) {
                // The lightest person can fit with the heaviest person
                i++;
            }
            // The heaviest person always gets on the boat
            j--;
        }

        return boats;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Boats: " + sol.numRescueBoats(new int[] { 1, 2 }, 3)); // 1
        System.out.println("Boats: " + sol.numRescueBoats(new int[] { 3, 2, 2, 1 }, 3)); // 3
        System.out.println("Boats: " + sol.numRescueBoats(new int[] { 3, 5, 3, 4 }, 5)); // 4
    }
}
