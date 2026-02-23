package leet_code.Problem_380_Medium_Insert_Delete_GetRandom_O1;

import java.util.*;

public class RandomizedSet {

    private Map<Integer, Integer> valToIndex;
    private List<Integer> vals;
    private Random rand;

    /**
     * Initializes the RandomizedSet.
     * Uses HashMap + ArrayList for O(1) performance.
     * Time: O(1), Space: O(N).
     * 
     * Khởi tạo RandomizedSet.
     * Sử dụng HashMap + ArrayList để đạt hiệu suất O(1).
     */
    public RandomizedSet() {
        valToIndex = new HashMap<>();
        vals = new ArrayList<>();
        rand = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if not present.
     */
    public boolean insert(int val) {
        if (valToIndex.containsKey(val))
            return false;

        valToIndex.put(val, vals.size());
        vals.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if present.
     */
    public boolean remove(int val) {
        if (!valToIndex.containsKey(val))
            return false;

        int index = valToIndex.get(val);
        int lastVal = vals.get(vals.size() - 1);

        // Swap with the last element
        // Hoán đổi với phần tử cuối cùng
        vals.set(index, lastVal);
        valToIndex.put(lastVal, index);

        // Remove the redundant last element
        // Xóa phần tử cuối cùng dư thừa
        vals.remove(vals.size() - 1);
        valToIndex.remove(val);

        return true;
    }

    /**
     * Returns a random element.
     */
    public int getRandom() {
        return vals.get(rand.nextInt(vals.size()));
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println("Insert 1: " + randomizedSet.insert(1));
        System.out.println("Remove 2: " + randomizedSet.remove(2));
        System.out.println("Insert 2: " + randomizedSet.insert(2));
        System.out.println("Random: " + randomizedSet.getRandom());
        System.out.println("Remove 1: " + randomizedSet.remove(1));
        System.out.println("Insert 2 (exists): " + randomizedSet.insert(2));
        System.out.println("Random: " + randomizedSet.getRandom());
    }
}
