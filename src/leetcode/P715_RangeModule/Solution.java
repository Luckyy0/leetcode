package leetcode.P715_RangeModule;

import java.util.TreeMap;

class RangeModule {
    TreeMap<Integer, Integer> map;

    public RangeModule() {
        map = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        Integer L = map.floorKey(left);
        Integer R = map.floorKey(right);

        if (L != null && map.get(L) >= left) {
            left = L;
        }
        if (R != null && map.get(R) > right) {
            right = map.get(R);
        }

        map.subMap(left, right).clear();
        map.put(left, right);
    }

    public boolean queryRange(int left, int right) {
        Integer L = map.floorKey(left);
        if (L == null)
            return false;
        return map.get(L) >= right;
    }

    public void removeRange(int left, int right) {
        Integer L = map.floorKey(left);
        Integer R = map.floorKey(right);

        // Handle split at end
        if (R != null && map.get(R) > right) {
            map.put(right, map.get(R));
        }

        // Handle split at start
        if (L != null && map.get(L) > left) {
            map.put(L, left);
        }

        map.subMap(left, right).clear();
    }
}
