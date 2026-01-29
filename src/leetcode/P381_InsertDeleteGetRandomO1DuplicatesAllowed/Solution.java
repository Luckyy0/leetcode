package leetcode.P381_InsertDeleteGetRandomO1DuplicatesAllowed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Solution {

    /**
     * Problem 381: Insert Delete GetRandom O(1) - Duplicates allowed
     * Approach: HashMap<Value, Set<Index>> + ArrayList
     * 
     * Time Complexity: O(1) average
     * Space Complexity: O(N)
     */
    public static class RandomizedCollection {
        private List<Integer> nums;
        private Map<Integer, Set<Integer>> idxMap;
        private Random rand;

        public RandomizedCollection() {
            nums = new ArrayList<>();
            idxMap = new HashMap<>();
            rand = new Random();
        }

        public boolean insert(int val) {
            boolean present = idxMap.containsKey(val);
            if (!present) {
                idxMap.put(val, new HashSet<>());
            }

            idxMap.get(val).add(nums.size());
            nums.add(val);

            return !present;
        }

        public boolean remove(int val) {
            if (!idxMap.containsKey(val)) {
                return false;
            }

            Set<Integer> indices = idxMap.get(val);
            int removeIdx = indices.iterator().next(); // remove any index

            int lastIdx = nums.size() - 1;
            int lastVal = nums.get(lastIdx);

            // Swap
            nums.set(removeIdx, lastVal);

            // Update indices
            indices.remove(removeIdx); // Remove the old index of val

            if (removeIdx != lastIdx) {
                // If we didn't remove the last element, we moved lastVal to removeIdx
                Set<Integer> lastIndices = idxMap.get(lastVal);
                lastIndices.remove(lastIdx);
                lastIndices.add(removeIdx);
            }

            nums.remove(lastIdx);

            if (indices.isEmpty()) {
                idxMap.remove(val);
            }

            return true;
        }

        public int getRandom() {
            return nums.get(rand.nextInt(nums.size()));
        }
    }

    public static void main(String[] args) {
        RandomizedCollection rc = new RandomizedCollection();

        // insert(1) -> true
        System.out.println("insert(1): " + rc.insert(1) + " (Expected: true)");

        // insert(1) -> false
        System.out.println("insert(1): " + rc.insert(1) + " (Expected: false)");

        // insert(2) -> true
        System.out.println("insert(2): " + rc.insert(2) + " (Expected: true)");

        // getRandom -> 1 or 2
        System.out.println("getRandom: " + rc.getRandom());

        // remove(1) -> true
        System.out.println("remove(1): " + rc.remove(1) + " (Expected: true)");

        // getRandom -> 1 or 2
        System.out.println("getRandom: " + rc.getRandom());
    }
}
