package leetcode.P1276_NumberOfBurgersWithNoWasteOfIngredients;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        // 2x = T - 2C
        int val = tomatoSlices - 2 * cheeseSlices;

        if (val < 0 || val % 2 != 0) {
            return new ArrayList<>();
        }

        int jumbo = val / 2;
        int small = cheeseSlices - jumbo;

        if (small < 0) {
            return new ArrayList<>();
        }

        return Arrays.asList(jumbo, small);
    }
}
