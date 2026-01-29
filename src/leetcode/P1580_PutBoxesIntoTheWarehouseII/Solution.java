package leetcode.P1580_PutBoxesIntoTheWarehouseII;

import java.util.Arrays;

public class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int n = warehouse.length;
        int[] prefixMin = new int[n];
        int[] suffixMin = new int[n];

        prefixMin[0] = warehouse[0];
        for (int i = 1; i < n; i++) {
            prefixMin[i] = Math.min(prefixMin[i - 1], warehouse[i]);
        }

        suffixMin[n - 1] = warehouse[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], warehouse[i]);
        }

        int[] effective = new int[n];
        for (int i = 0; i < n; i++) {
            effective[i] = Math.max(prefixMin[i], suffixMin[i]);
        }

        Arrays.sort(effective);
        Arrays.sort(boxes);

        int count = 0;
        int boxIdx = 0;
        int whIdx = 0;

        // Greedy: Try to fit smallest boxes into smallest available rooms
        while (boxIdx < boxes.length && whIdx < n) {
            if (effective[whIdx] >= boxes[boxIdx]) {
                // Room fits the box
                count++;
                boxIdx++;
                whIdx++;
            } else {
                // Room too small for this box (and any subsequent box)
                // Discard room
                whIdx++;
            }
        }

        return count;
    }
}
