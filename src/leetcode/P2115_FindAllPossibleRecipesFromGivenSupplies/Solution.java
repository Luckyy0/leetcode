package leetcode.P2115_FindAllPossibleRecipesFromGivenSupplies;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> supplySet = new HashSet<>();
        for (String s : supplies)
            supplySet.add(s);

        Set<String> recipeSet = new HashSet<>();
        Map<String, Integer> recipeToIndex = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            recipeSet.add(recipes[i]);
            recipeToIndex.put(recipes[i], i);
        }

        Map<String, List<String>> adj = new HashMap<>(); // Prerequisite -> List<DependentRecipe>
        Map<String, Integer> inDegree = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            String r = recipes[i];
            List<String> ing = ingredients.get(i);
            int degree = 0;
            boolean impossible = false;

            for (String item : ing) {
                if (supplySet.contains(item))
                    continue;
                if (recipeSet.contains(item)) {
                    adj.computeIfAbsent(item, k -> new ArrayList<>()).add(r);
                    degree++;
                } else {
                    // Item not in supplies and not a recipe -> Impossible
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                inDegree.put(r, Integer.MAX_VALUE);
            } else {
                inDegree.put(r, degree);
            }
        }

        Queue<String> q = new ArrayDeque<>();
        for (String r : recipes) {
            if (inDegree.get(r) == 0) {
                q.offer(r);
            }
        }

        List<String> res = new ArrayList<>();
        while (!q.isEmpty()) {
            String curr = q.poll();
            res.add(curr);

            if (adj.containsKey(curr)) {
                for (String next : adj.get(curr)) {
                    int d = inDegree.get(next);
                    if (d != Integer.MAX_VALUE) {
                        d--;
                        inDegree.put(next, d);
                        if (d == 0) {
                            q.offer(next);
                        }
                    }
                }
            }
        }

        return res;
    }
}
