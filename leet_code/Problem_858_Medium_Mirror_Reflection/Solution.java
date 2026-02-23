package leet_code.Problem_858_Medium_Mirror_Reflection;

/**
 * Problem 858: Mirror Reflection
 * https://leetcode.com/problems/mirror-reflection/
 */
public class Solution {

    /**
     * Determines which receptor the laser hits first.
     * Strategy: Unfold the reflections into a straight line on an infinite grid.
     * Let n * p = m * q be the smallest multiple.
     * m is the number of vertical segments, n is the number of horizontal segments.
     * 
     * @param p Side length of the square.
     * @param q Hit distance on the right wall.
     * @return Receptor ID (0, 1, 2).
     * 
     *         Tóm tắt chiến lược:
     *         Thay vì mô phỏng phản xạ, chúng ta tưởng tượng tia laser đi thẳng qua
     *         các
     *         ô vuông p x p xếp chồng lên nhau. Công thức n * p = m * q giúp tìm
     *         điểm đầu tiên tia laser chạm góc. Chúng ta rút gọn p và q cho đến khi
     *         ít nhất một trong hai là số lẻ để xét tính chẵn lẻ.
     */
    public int mirrorReflection(int p, int q) {
        // Find the simplest ratio of p and q by removing factors of 2
        while (p % 2 == 0 && q % 2 == 0) {
            p /= 2;
            q /= 2;
        }

        // n * p = m * q
        // If p is even: the ray hits the left wall (receptor 2)
        if (p % 2 == 0) {
            return 2;
        }

        // If q is even: the ray hits the bottom-right receptor (receptor 0)
        if (q % 2 == 0) {
            return 0;
        }

        // Otherwise (both odd): hit the top-right receptor (receptor 1)
        return 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Receptor: " + sol.mirrorReflection(2, 1)); // 2
        System.out.println("Receptor: " + sol.mirrorReflection(3, 1)); // 1
    }
}
