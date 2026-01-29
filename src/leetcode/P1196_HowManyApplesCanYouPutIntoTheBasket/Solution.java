package leetcode.P1196_HowManyApplesCanYouPutIntoTheBasket;

import java.util.Arrays;

class Solution {
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int sum = 0;
        int count = 0;
        for (int w : weight) {
            sum += w;
            if (sum > 5000)
                break;
            count++;
        }
        return count;
    }
}
