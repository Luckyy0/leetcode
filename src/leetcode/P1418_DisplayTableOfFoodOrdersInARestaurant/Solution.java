package leetcode.P1418_DisplayTableOfFoodOrdersInARestaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<Integer, Map<String, Integer>> tables = new TreeMap<>();
        Set<String> foodItems = new TreeSet<>();

        for (List<String> order : orders) {
            int table = Integer.parseInt(order.get(1));
            String food = order.get(2);

            foodItems.add(food);
            tables.putIfAbsent(table, new HashMap<>());
            Map<String, Integer> counts = tables.get(table);
            counts.put(food, counts.getOrDefault(food, 0) + 1);
        }

        List<List<String>> res = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(foodItems);
        res.add(header);

        for (Integer table : tables.keySet()) { // TreeMap handles sorting key
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(table));
            Map<String, Integer> counts = tables.get(table);

            for (String food : foodItems) {
                row.add(String.valueOf(counts.getOrDefault(food, 0)));
            }
            res.add(row);
        }

        return res;
    }
}
