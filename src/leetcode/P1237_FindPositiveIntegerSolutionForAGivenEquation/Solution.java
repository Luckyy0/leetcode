package leetcode.P1237_FindPositiveIntegerSolutionForAGivenEquation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 */
interface CustomFunction {
    // Returns f(x, y) for any given positive integers x and y.
    // Note that f(x, y) is increasing with respect to both x and y.
    // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
    public int f(int x, int y);
}

class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        int x = 1, y = 1000;

        while (x <= 1000 && y >= 1) {
            int val = customfunction.f(x, y);
            if (val == z) {
                res.add(Arrays.asList(x, y));
                x++;
                y--;
            } else if (val > z) {
                y--; // value too big, decrease y
            } else {
                x++; // value too small, increase x
            }
        }

        return res;
    }
}
