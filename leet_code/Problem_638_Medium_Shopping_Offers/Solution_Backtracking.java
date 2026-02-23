package leet_code.Problem_638_Medium_Shopping_Offers;

import java.util.*;

public class Solution_Backtracking {

    /**
     * Finds the lowest price to buy exactly the given needs.
     * Strategy: Backtracking with Memoization.
     */
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return solve(price, special, needs, new HashMap<>());
    }

    private int solve(List<Integer> price, List<List<Integer>> special, List<Integer> needs,
            Map<List<Integer>, Integer> memo) {
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }

        // Case 1: Buy everything at individual prices (baseline)
        int minCost = calculateDirectPurchase(price, needs);

        // Case 2: Try each special offer
        for (List<Integer> offer : special) {
            List<Integer> nextNeeds = tryApplyOffer(needs, offer);
            if (nextNeeds != null) {
                // If the offer is valid, cost = offer price + cost for remaining needs
                int offerPrice = offer.get(offer.size() - 1);
                minCost = Math.min(minCost, offerPrice + solve(price, special, nextNeeds, memo));
            }
        }

        memo.put(needs, minCost);
        return minCost;
    }

    private int calculateDirectPurchase(List<Integer> price, List<Integer> needs) {
        int cost = 0;
        for (int i = 0; i < price.size(); i++) {
            cost += price.get(i) * needs.get(i);
        }
        return cost;
    }

    /**
     * Checks if a special offer can be applied to current needs.
     * Returns the remaining needs if valid, otherwise null.
     */
    private List<Integer> tryApplyOffer(List<Integer> needs, List<Integer> offer) {
        List<Integer> next = new ArrayList<>();
        for (int i = 0; i < needs.size(); i++) {
            if (offer.get(i) > needs.get(i)) {
                return null; // Offer provides more than needed
            }
            next.add(needs.get(i) - offer.get(i));
        }
        return next;
    }

    public static void main(String[] args) {
        Solution_Backtracking sol = new Solution_Backtracking();
        List<Integer> price = Arrays.asList(2, 5);
        List<List<Integer>> special = Arrays.asList(
                Arrays.asList(3, 0, 5),
                Arrays.asList(1, 2, 10));
        List<Integer> needs = Arrays.asList(3, 2);
        System.out.println("Min Cost: " + sol.shoppingOffers(price, special, needs)); // 14
    }
}
