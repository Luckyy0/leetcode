package leetcode.P605_CanPlaceFlowers;

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0)
            return true;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                // Check left and right
                // Kiểm tra bên trái và bên phải
                boolean leftEmpty = (i == 0) || (flowerbed[i - 1] == 0);
                boolean rightEmpty = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);

                if (leftEmpty && rightEmpty) {
                    flowerbed[i] = 1;
                    n--;
                    if (n == 0)
                        return true;
                }
            }
        }

        return n <= 0;
    }
}
