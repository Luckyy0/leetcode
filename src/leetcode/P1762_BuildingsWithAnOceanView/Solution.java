package leetcode.P1762_BuildingsWithAnOceanView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<>();
        int maxH = -1;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > maxH) {
                list.add(i);
                maxH = heights[i];
            }
        }

        // Reverse to get increasing order
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(list.size() - 1 - i);
        }
        return res;
    }
}
