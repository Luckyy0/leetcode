package leet_code.Problem_599_Easy_Minimum_Index_Sum_of_Two_Lists;

import java.util.*;

public class Solution_HashMap {

    /**
     * Finds common strings with the minimum index sum.
     * Strategy: Store index of one list in a map, scan the second list.
     * Time: O(N + M), Space: O(N).
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> res = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;

        for (int j = 0; j < list2.length; j++) {
            if (map.containsKey(list2[j])) {
                int sum = j + map.get(list2[j]);
                if (sum < minSum) {
                    // New minimum found: reset result list
                    minSum = sum;
                    res.clear();
                    res.add(list2[j]);
                } else if (sum == minSum) {
                    // Tying minimum found: add to list
                    res.add(list2[j]);
                }
            }
        }

        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Solution_HashMap solution = new Solution_HashMap();
        String[] l1 = { "Shogun", "Tapioca Express", "Burger King", "KFC" };
        String[] l2 = { "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun" };
        System.out.println("Result: " + Arrays.toString(solution.findRestaurant(l1, l2))); // ["Shogun"]
    }
}
