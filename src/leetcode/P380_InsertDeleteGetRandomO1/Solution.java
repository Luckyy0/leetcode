package leetcode.P380_InsertDeleteGetRandomO1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Solution {

    /**
     * Problem 380: Insert Delete GetRandom O(1)
     * Approach: HashMap + ArrayList Swap
     * 
     * Time Complexity: O(1) average
     * Space Complexity: O(N)
     */
    public static class RandomizedSet {
        private Map<Integer, Integer> map;
        private List<Integer> list;
        private Random rand;

        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            rand = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }

            map.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }

            int index = map.get(val);
            int lastElement = list.get(list.size() - 1);

            // Swap if not removing the last element
            if (index != list.size() - 1) {
                list.set(index, lastElement);
                map.put(lastElement, index);
            }

            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }

    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();

        System.out.println("insert(1): " + rs.insert(1) + " (Expected: true)");
        System.out.println("remove(2): " + rs.remove(2) + " (Expected: false)");
        System.out.println("insert(2): " + rs.insert(2) + " (Expected: true)");

        // Random check
        int randVal = rs.getRandom();
        System.out.println("getRandom: " + randVal + " (Expected: 1 or 2)");

        System.out.println("remove(1): " + rs.remove(1) + " (Expected: true)");
        System.out.println("insert(2): " + rs.insert(2) + " (Expected: false)");

        randVal = rs.getRandom();
        System.out.println("getRandom: " + randVal + " (Expected: 2)");
    }
}
