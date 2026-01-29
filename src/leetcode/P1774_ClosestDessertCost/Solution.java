package leetcode.P1774_ClosestDessertCost;

import java.util.Arrays;

public class Solution {
    private int closest;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        closest = baseCosts[0];

        for (int b : baseCosts) {
            dfs(toppingCosts, 0, b, target);
        }

        return closest;
    }

    private void dfs(int[] toppings, int idx, int currentCost, int target) {
        // Update closest
        int diffCurrent = Math.abs(target - currentCost);
        int diffClosest = Math.abs(target - closest);

        if (diffCurrent < diffClosest) {
            closest = currentCost;
        } else if (diffCurrent == diffClosest) {
            if (currentCost < closest)
                closest = currentCost;
        }

        // Pruning: if currentCost > target and diff > best diff, adding more positive
        // costs won't help
        // Be careful: if currentCost > target, diff is increasing.
        if (currentCost > target && Math.abs(currentCost - target) >= diffClosest)
            return;

        if (idx == toppings.length)
            return;

        // 0 toppings
        dfs(toppings, idx + 1, currentCost, target);
        // 1 topping
        dfs(toppings, idx + 1, currentCost + toppings[idx], target);
        // 2 toppings
        dfs(toppings, idx + 1, currentCost + 2 * toppings[idx], target);
    }
}
