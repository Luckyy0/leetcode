package leetcode.P679_24Game;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int c : cards)
            nums.add((double) c);
        return solve(nums);
    }

    private boolean solve(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) < 1e-6;
        }

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i == j)
                    continue;

                List<Double> nextNums = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j)
                        nextNums.add(nums.get(k));
                }

                for (double res : getResults(nums.get(i), nums.get(j))) {
                    nextNums.add(res);
                    if (solve(nextNums))
                        return true;
                    nextNums.remove(nextNums.size() - 1);
                }
            }
        }
        return false;
    }

    private List<Double> getResults(double a, double b) {
        List<Double> res = new ArrayList<>();
        res.add(a + b);
        res.add(a - b);
        res.add(a * b);
        if (Math.abs(b) > 1e-6)
            res.add(a / b);
        return res;
    }
}
