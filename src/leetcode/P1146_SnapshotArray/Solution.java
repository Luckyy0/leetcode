package leetcode.P1146_SnapshotArray;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class SnapshotArray {
    List<TreeMap<Integer, Integer>> arr;
    int snapId = 0;

    public SnapshotArray(int length) {
        arr = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            map.put(0, 0); // Initial value 0 at snap 0
            arr.add(map);
        }
    }

    public void set(int index, int val) {
        arr.get(index).put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        return arr.get(index).floorEntry(snap_id).getValue();
    }
}
