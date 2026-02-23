package leet_code.Problem_605_Easy_Can_Place_Flowers;

public class Solution_Greedy {

    /**
     * Determines if n flowers can be planted.
     * Strategy: Greedy linear scan with boundary checks.
     * Time: O(N), Space: O(1).
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0)
            return true;

        int length = flowerbed.length;
        for (int i = 0; i < length; i++) {
            // Check current, left, and right status
            if (flowerbed[i] == 0) {
                boolean leftEmpty = (i == 0) || (flowerbed[i - 1] == 0);
                boolean rightEmpty = (i == length - 1) || (flowerbed[i + 1] == 0);

                if (leftEmpty && rightEmpty) {
                    flowerbed[i] = 1; // Plant the flower
                    n--;
                    if (n == 0)
                        return true;
                }
            }
        }

        return n <= 0;
    }

    public static void main(String[] args) {
        Solution_Greedy solution = new Solution_Greedy();
        int[] fb = { 1, 0, 0, 0, 1 };
        System.out.println("Can place 1: " + solution.canPlaceFlowers(fb.clone(), 1)); // true
        System.out.println("Can place 2: " + solution.canPlaceFlowers(fb.clone(), 2)); // false
    }
}
