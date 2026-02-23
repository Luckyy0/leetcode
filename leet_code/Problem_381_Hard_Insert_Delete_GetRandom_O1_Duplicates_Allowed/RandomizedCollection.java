package leet_code.Problem_381_Hard_Insert_Delete_GetRandom_O1_Duplicates_Allowed;

import java.util.*;

public class RandomizedCollection {

    private List<Integer> nums;
    private Map<Integer, Set<Integer>> valToIndices;
    private Random rand;

    /**
     * Initializes the RandomizedCollection.
     * Uses ArrayList + Map of LinkedHashSets for O(1) performance with duplicates.
     * Time: O(1), Space: O(N).
     * 
     * Khởi tạo RandomizedCollection.
     * Sử dụng ArrayList + Bản đồ các LinkedHashSet để đạt hiệu năng O(1) với các
     * phần tử trùng lặp.
     */
    public RandomizedCollection() {
        nums = new ArrayList<>();
        valToIndices = new HashMap<>();
        rand = new Random();
    }

    /**
     * Inserts a value to the collection. Returns true if not present.
     */
    public boolean insert(int val) {
        boolean notPresent = !valToIndices.containsKey(val);
        if (notPresent) {
            valToIndices.put(val, new LinkedHashSet<>());
        }
        valToIndices.get(val).add(nums.size());
        nums.add(val);
        return notPresent;
    }

    /**
     * Removes a value from the collection. Returns true if present.
     */
    public boolean remove(int val) {
        if (!valToIndices.containsKey(val) || valToIndices.get(val).isEmpty()) {
            return false;
        }

        // Get an index of the value to remove
        Set<Integer> indexSet = valToIndices.get(val);
        int removeIdx = indexSet.iterator().next();
        indexSet.remove(removeIdx);

        // Get the last element in the list
        int lastIdx = nums.size() - 1;
        int lastVal = nums.get(lastIdx);

        // If the removed element is not the last one, swap it
        if (removeIdx < lastIdx) {
            nums.set(removeIdx, lastVal);
            Set<Integer> lastValIndices = valToIndices.get(lastVal);
            lastValIndices.remove(lastIdx);
            lastValIndices.add(removeIdx);
        }

        nums.remove(lastIdx);

        // Clean up the map if no more indices exist for this value
        if (indexSet.isEmpty()) {
            valToIndices.remove(val);
        }

        return true;
    }

    /**
     * Returns a random element.
     */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }

    public static void main(String[] args) {
        RandomizedCollection collection = new RandomizedCollection();
        System.out.println("Insert 1: " + collection.insert(1)); // true
        System.out.println("Insert 1: " + collection.insert(1)); // false
        System.out.println("Insert 2: " + collection.insert(2)); // true
        System.out.println("Random: " + collection.getRandom()); // 1 or 2
        System.out.println("Remove 1: " + collection.remove(1)); // true
        System.out.println("Random: " + collection.getRandom()); // 1 or 2
    }
}
