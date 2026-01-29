package leetcode.P624_MaximumDistanceInArrays;

import java.util.List;

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        if (arrays == null || arrays.size() < 2)
            return 0;

        int result = 0;
        int minVal = arrays.get(0).get(0);
        int maxVal = arrays.get(0).get(arrays.get(0).size() - 1);

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> currentArray = arrays.get(i);
            int currentMin = currentArray.get(0);
            int currentMax = currentArray.get(currentArray.size() - 1);

            // Calculate potential max distances comparing with previous min/max
            // Tính khoảng cách tối đa tiềm năng so với min/max trước đó
            result = Math.max(result, Math.abs(currentMax - minVal));
            result = Math.max(result, Math.abs(maxVal - currentMin));

            // Update global min/max
            // Cập nhật min/max toàn cục
            minVal = Math.min(minVal, currentMin);
            maxVal = Math.max(maxVal, currentMax);
        }

        return result;
    }
}
