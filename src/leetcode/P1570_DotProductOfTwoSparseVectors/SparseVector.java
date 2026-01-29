package leetcode.P1570_DotProductOfTwoSparseVectors;

import java.util.HashMap;
import java.util.Map;

public class SparseVector {

    // Map to store non-zero values: index -> value
    public Map<Integer, Integer> indexToValue;

    SparseVector(int[] nums) {
        indexToValue = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                indexToValue.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        Map<Integer, Integer> smallerMap;
        Map<Integer, Integer> largerMap;

        if (this.indexToValue.size() < vec.indexToValue.size()) {
            smallerMap = this.indexToValue;
            largerMap = vec.indexToValue;
        } else {
            smallerMap = vec.indexToValue;
            largerMap = this.indexToValue;
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> entry : smallerMap.entrySet()) {
            int idx = entry.getKey();
            int val = entry.getValue();

            if (largerMap.containsKey(idx)) {
                result += val * largerMap.get(idx);
            }
        }

        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
